package tool.mastery.core;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

public class BeanUtil {

	public static boolean isNumber(Class<?> entityClass, String name) {
		String className = null;
		// 取得这个参数在Bean中的数据类开
		try {
			Field field = entityClass.getDeclaredField(name);
			Class<?> cls = field.getType();
			// System.out.println(cls);
			className = cls.getSimpleName().toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return className.indexOf("int") == 0
				|| className.indexOf("integer") == 0
				|| className.indexOf("float") == 0
				|| className.indexOf("double") == 0
				|| className.indexOf("nember") == 0
				|| className.indexOf("numeric") == 0;
	}

	/**
	 * 给bean对象的某个属性赋值
	 * 
	 * @param bean
	 * @param paramName
	 * @param value
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static void setProperty(Object bean, String paramName, String value)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		// 取得这个参数在Bean中的数据类开
		Class<?> cls = PropertyUtils
				.getPropertyType(bean, paramName.toString());
		// 把相应的数据转换成对应的数据类型
		Object beanValue = ConvertUtil.convert(value, cls);
		// 添充Bean值
		PropertyUtils.setProperty(bean, paramName.toString(), beanValue);
	}

	/**
	 * 将oldBean中对应属性的值赋值给bean对象
	 * @param bean
	 * @param oldBean
	 * @param paramName
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static void setProperty(Object bean, Object oldBean, String paramName)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		PropertyUtils.setProperty(bean, paramName,
				PropertyUtils.getProperty(oldBean, paramName));
	}
}
