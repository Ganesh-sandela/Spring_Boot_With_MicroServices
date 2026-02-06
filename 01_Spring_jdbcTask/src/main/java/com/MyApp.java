package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("Beans.xml");
		
		BookService bean = ctx.getBean(BookService.class);
		bean.savebook();
		bean.read();
	}

}
