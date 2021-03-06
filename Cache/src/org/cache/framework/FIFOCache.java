package org.cache.framework;

import java.util.Iterator;
import java.util.LinkedHashMap;

import org.cache.interceptor.Interceptor;

/**
 * FIFO(先进先出置换算法)具体实现
 * @author mastery
 * @Time 2015-3-14 下午11:00:40
 * 
 * @param <K>
 * @param <V>
 */
public class FIFOCache<K, V> extends AbstractCacheMap<K, V> {

	public FIFOCache(int cacheSize, long defaultExpire) {
		super(cacheSize, defaultExpire);
		cacheMap = new LinkedHashMap<K, CacheObject<K, V>>(cacheSize + 1);
	}
	
	public FIFOCache(int cacheSize, long defaultExpire, Interceptor interceptor) {
		this(cacheSize, defaultExpire);
		this.interceptor = interceptor;
	}


	@Override
	protected int eliminateCache() {
		int count = 0;
		K firstKey = null;
		V firstValue = null;
		Iterator<CacheObject<K, V>> iterator = cacheMap.values().iterator();
		while (iterator.hasNext()) {
			CacheObject<K, V> cacheObject = iterator.next();

			if (cacheObject.isExpired()) {
				iterator.remove();
				count++;
			} else {
				if (firstKey == null){
					firstKey = cacheObject.key;
					firstValue = cacheObject.cacheObject;
				}
					
			}
		}

		if (firstKey != null && isFull()) {// 删除过期对象还是满,继续删除链表第一个
			cacheMap.remove(firstKey);
			proceed(firstValue);
		}

		return count;
	}

}
