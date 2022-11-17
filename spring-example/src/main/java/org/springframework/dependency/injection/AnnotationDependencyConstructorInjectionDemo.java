package org.springframework.dependency.injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.example.pojo.User;


/**
 * 基于XML资源的依赖Setter方法注入
 */
@ImportResource(value = "classpath:/META-INF/dependency/application-lookup.xml")
public class AnnotationDependencyConstructorInjectionDemo {
	private final User user;

	public AnnotationDependencyConstructorInjectionDemo(User user) {
		this.user = user;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AnnotationDependencyConstructorInjectionDemo.class);
		applicationContext.refresh();
		System.out.println(applicationContext.getBean(UserHolder.class));
		applicationContext.close();
	}


	@Bean
	public UserHolder userHolder() {
		return new UserHolder(user);
	}
}
