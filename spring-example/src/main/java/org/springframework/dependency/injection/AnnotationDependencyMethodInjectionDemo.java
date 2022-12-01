package org.springframework.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.example.pojo.User;

import javax.annotation.Resource;


/**
 * 基于方法的注入方式
 */
@ImportResource(value = "classpath:/META-INF/dependency/application-lookup.xml")
public class AnnotationDependencyMethodInjectionDemo {

	private UserHolder userHolder;

	@Autowired
	public void initialUserHolder(UserHolder userHolder) {
		this.userHolder = userHolder;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AnnotationDependencyMethodInjectionDemo.class);
		applicationContext.refresh();
		AnnotationDependencyMethodInjectionDemo demo
				= applicationContext.getBean(AnnotationDependencyMethodInjectionDemo.class);
		System.out.println(demo.userHolder);
		applicationContext.close();
	}

	@Bean
	public UserHolder userHolder(User user) {
		return new UserHolder(user);
	}
}
