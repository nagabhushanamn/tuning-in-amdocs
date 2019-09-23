package com.example.container;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WebContainer {

	public void process(String url) {
		try {
			
			System.out.println("-------------------");
			
			Class<?> clazz = Class.forName("com.example.component.WebComponent");
			
			System.out.println("-------------------");
			
			Object instance = clazz.newInstance();
			Method[] methods = clazz.getMethods();

			for (Method method : methods) {
				RequestMapping rm = method.getAnnotation(RequestMapping.class);
				if (rm != null) {
					String givenUrl = rm.url();
					if (url.equals(givenUrl)) {
						method.invoke(instance, new Object[] {});
					}
				}
			}

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
