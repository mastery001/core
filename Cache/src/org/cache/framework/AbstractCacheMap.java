package org.cache.framework;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.cache.interceptor.Interceptor;

/**
 * 基本实现抽象类
 * 默认实现
 * @author mastery
 * @Time 2015-3-14 下午10:13:30
 * 
 * @param <K>
 * @param <V>
 */
public abstract class AbstractCacheMap<K , V> implements Cache<K , V>{

	class CacheObject<K2 , V2> {
		CacheObject(K2 key , V2 value , long tt1) {
			this.key = key;
			this.cacheObject = value;
			this.tt1 = tt1;
			this.lastAccess = System.currentTimeMillis();
		}
		
		final K2 key;
		final V2 cacheObject;
		long lastAccess;	// 最后访问时间
		long accessCount;	// 访问次数
		long tt1;			// 对象存活时间<time-to-live)
		
		boolean isExpired() {
			if(tt1 == 0) {
				return false;
			}
			boolean flag = lastAccess + tt1 < System.currentTimeMillis();
			if(flag) {
				proceed(cacheObject);
			}
			return flag;
		}

		V2 getObject() {
			lastAccess = System.currentTimeMillis();
			accessCount++;
			return cacheObject;
		}

		@Override
		public String toString() {
			return "CacheObject [key=" + key + ", cacheObject=" + cacheObject
					+ ", lastAccess=" + lastAccess + ", accessCount="
					+ accessCount + ", tt1=" + tt1 + "]";
		}
		
	}
	
	protected Map<K , CacheObject<K , V>> cacheMap;
	
	private final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
	private final Lock readLock = cacheLock.readLock();
	private final Lock writeLock = cacheLock.writeLock();
	
	protected int cacheSize;	// 缓存大小， 0 - 无限制
	
	protected boolean existCustomExpire;	// 是否设置默认过期时间
	
	protected long defaultExpire;     // 默认过期时间, 0 -> 永不过期
	
	protected Interceptor interceptor;		// 用于释放时拦截的操作
	
	public AbstractCacheMap(int cacheSize , long defaultExpire) {
		this.cacheSize = cacheSize;
		this.defaultExpire = defaultExpire;
	}
	
	public AbstractCacheMap(int cacheSize , long defaultExpire , Interceptor interceptor) {
		this(cacheSize,defaultExpire);
		this.interceptor = interceptor;
	}
	
	protected boolean isNeedClearExpiredObject() {
		return defaultExpire > 0 || existCustomExpire;
	}

	@Override
	public int size() {
		return cacheMap.size();
	}

	@Override
	public long getDefaultExpire() {
		return this.defaultExpire;
	}

	@Override
	public void put(K key, V value) {
		put(key, value, defaultExpire);
		
	}

	@Override
	public void put(K key, V value, long expire) {
		writeLock.lock();
        try {
            CacheObject<K,V> co = new CacheObject<K,V>(key, value, expire);
            if(expire != 0) {
            	existCustomExpire = true;
            }
            if(isFull()) {
            	eliminate();
            }
            cacheMap.put(key, co);
        }finally {
        	writeLock.unlock();
        }
	}

	@Override
	public V get(K key) {
		readLock.lock();
		try {
			CacheObject<K , V> co = cacheMap.get(key);
			if(co == null) {
				return null;
			}
			if(co.isExpired()) {
				cacheMap.remove(key);
				return null;
			}
			return co.getObject();
		}finally {
			readLock.unlock();
		}
	}

	@Override
	public final int eliminate() {
		writeLock.lock();
		try {
			return eliminateCache();
		}finally {
			writeLock.unlock();
		}
	}

	/**
	 * 淘汰对象具体实现
	 * @return
	 */
	protected abstract int eliminateCache();

	@Override
	public boolean isFull() {
		if(cacheSize == 0) {
			return false;
		}
		return cacheMap.size() >= cacheSize;
	}

	@Override
	public void remove(K key) {
		writeLock.lock();
		try {
			cacheMap.remove(key);
		}finally {
			writeLock.unlock();
		}
		
	}

	@Override
	public void clear() {
		writeLock.lock();
		try {
			cacheMap.clear();
		}finally {
			writeLock.unlock();
		}
	}

	@Override
	public int getCacheSize() {
		return this.cacheSize;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean containsKey(K key) {
		return cacheMap.containsKey(key);
	}

	protected <V2> void proceed(V2 cacheObject) {
		// 如果当前对象到期，则将该对象处理后释放
		if(interceptor != null) {
			interceptor.proceed(cacheObject);
		}
	}
	
	public void printMap() {
		writeLock.lock();
		try {
			Set<Map.Entry<K, CacheObject<K, V>>> set = cacheMap.entrySet();
			for(Iterator<Map.Entry<K, CacheObject<K, V>>> it = set.iterator() ; it.hasNext();) {
				Entry<K, CacheObject<K, V>> entry = it.next();
				System.out.println("key is : " + entry.getKey() + "; and value is : "
						+ entry.getValue());
			}
		}finally {
			writeLock.unlock();
		}
		
	}
	
}
