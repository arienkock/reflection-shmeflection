package org.sample;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ReflectionBean extends BaseBean {
	private static Map<String, Method> setterMap = new HashMap<String, Method>();
	private static Map<String, Method> getterMap = new HashMap<String, Method>();
	static {
		Method[] declaredMethods = BaseBean.class.getDeclaredMethods();
		for (int i=0; i<declaredMethods.length; i++) {
			Method method = declaredMethods[i];
			String methodName = method.getName();
			if (methodName.length() > 3 && methodName.startsWith("set")) {
				String fieldName = Character.toLowerCase(
						methodName.charAt(3)) + methodName.substring(4);
				setterMap.put(fieldName, method);
			} else if (methodName.length() > 3 && methodName.startsWith("get")) {
				String fieldName = Character.toLowerCase(
						methodName.charAt(3)) + methodName.substring(4);
				getterMap.put(fieldName, method);
			}
		}
	}
	
	@Override
	public void set(String field, Object value) {
		Method method = setterMap.get(field);
		if (method == null) {
			throw new AssertionError();
		}
		try {
			method.invoke(this, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Object get(String field) {
		Method method = getterMap.get(field);
		if (method == null) {
			throw new AssertionError();
		}
		try {
			return method.invoke(this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
}
