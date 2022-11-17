package org.springframework.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.example.pojo.User;


/**
 * 基于XML资源的依赖Setter方法注入
 */
@ImportResource(value = "classpath:/META-INF/dependency/application-lookup.xml")
public class AnnotationDependencySetterInjectionDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AnnotationDependencySetterInjectionDemo.class);
		applicationContext.refresh();
		System.out.println(applicationContext.getBean(UserHolder.class));
		applicationContext.close();
	}


	@Bean
	public UserHolder userHolder(User user) {
		return new UserHolder(user);
	}
}
