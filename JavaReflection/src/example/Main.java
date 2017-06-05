package example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("example.User");
			System.out.println(c.getName());
			System.out.println(c.getSimpleName());

			Field[] fields = c.getDeclaredFields();
			for (Field field : fields) {
				System.out.println("property " + field.getName());
			}

			Constructor[] constructors = c.getConstructors();
			for (Constructor constructor : constructors) {
				System.out.println("Constructor : " + constructor);
			}

			Method[] methods = c.getMethods();
			for (Method method : methods) {
				System.out.println("Method " + method);
			}

			User user = (User) c.newInstance();
			user.setUserName("tuankhoi");
			user.setPassword("123");

			System.out.println(user.getUserName() + "_" + user.getPassword());

			Method method = c.getMethod("printHello", String.class);
			method.invoke(user, "World");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
