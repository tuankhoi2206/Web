package test;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class App {
	public static void main(String[] args) {
		
		 XmlWebApplicationContext context = new XmlWebApplicationContext();
         context.setConfigLocation("/WEB-INF/beans.xml");
		
		
	}
}
