package org.cache.interceptor;

/**
 * 用于在释放时执行的操作
 * @author Administrator
 *
 */
public interface Interceptor {
	
	/**
	 * 将缓存的值传递
	 * @param value
	 */
	<V> void proceed(V value) throws InterceptorException;
}
