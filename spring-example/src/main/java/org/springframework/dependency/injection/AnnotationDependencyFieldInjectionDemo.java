package org.springframework.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.example.pojo.User;

import javax.annotation.Resource;


/**
 * 基于字段的注入方式
 */
@ImportResource(value = "classpath:/META-INF/dependency/application-lookup.xml")
public class AnnotationDependencyFieldInjectionDemo {
	//	@Autowired // @Autowired会忽略掉静态字段
//	private UserHolder holder;
	@Resource
	private UserHolder holder;

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext
//				applicationContext = new AnnotationConfigApplicationContext();
//		applicationContext.register(AnnotationDependencyFieldInjectionDemo.class);
//		applicationContext.refresh();
//		AnnotationDependencyFieldInjectionDemo demo
//				= applicationContext.getBean(AnnotationDependencyFieldInjectionDemo.class);
//		System.out.println(demo.holder);
//		applicationContext.close();
	}

	@Bean
	public UserHolder userHolder(User user) {
		return new UserHolder(user);
	}
}
