package org.springframework.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.example.pojo.User;

import java.util.Iterator;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/4 11:30
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
public class ObjectProviderDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext();
		context.register(ObjectProviderDemo.class);
		context.refresh();
		lookUpByObjectProvider(context);
		lookUpIfAvailable(context);
		lookUpByStreamOps(context);
		context.close();
	}

	private static void lookUpByStreamOps(AnnotationConfigApplicationContext context) {
		ObjectProvider<String> beanProvider = context.getBeanProvider(String.class);
		Iterator<String> iterator = beanProvider.iterator();
		iterator.forEachRemaining(System.out::println);
	}

	private static void lookUpIfAvailable(AnnotationConfigApplicationContext context) {
		ObjectProvider<User> beanProvider = context.getBeanProvider(User.class);
		User user = beanProvider.getIfAvailable(User::new);
		System.out.println(user);
	}

	private static void lookUpByObjectProvider(ApplicationContext context) {
		ObjectProvider<String> beanProvider = context.getBeanProvider(String.class);
		System.out.println(beanProvider.getIfAvailable());
	}

	@Bean
	@Primary
	public String helloWorld() {
		return "Hello,World";
	}

	@Bean
	public String message() {
		return "message";
	}
}
