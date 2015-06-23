package tool.mastery.core;

import java.lang.reflect.Method;

public class ReflectUtils {

	/**
	 * @Title: getMethod
	 * @Description: 获取当前类或者父类中的指定方法
	 * @param @param count 限定只能查找当前类或者其父类
	 * @param @param clazz 当前类的字节码
	 * @param @param methodName 方法名
	 * @param @param parameterTypes 方法参数
	 * @param @return
	 * @param @throws SecurityException
	 * @param @throws NoSuchMethodException
	 * @return Method 返回类型
	 * @throws
	 */
	public static Method getMethod(int count, Class<?> clazz, String methodName,
			Class<?>... parameterTypes) throws SecurityException,
			NoSuchMethodException {
		Method method = null;
		try {
			if (count < 2) {
				method = clazz.getDeclaredMethod(methodName, parameterTypes);
			}
		} catch (Exception e) {
			return getMethod(++count, clazz.getSuperclass(), methodName,
					parameterTypes);
		}
		return method;
	}
	
}
