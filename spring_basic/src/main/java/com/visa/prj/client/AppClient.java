package com.visa.prj.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.visa.prj.service.SampleService;

public class AppClient {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app1.xml");
		String[] beans = ctx.getBeanDefinitionNames();
		for(String name : beans) {
			System.out.println(name);
		}
		SampleService service = ctx.getBean("sampleService", SampleService.class);
		service.insert();
		
	}
}
