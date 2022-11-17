package org.springframework.dependency.lookup.exception;


import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.example.pojo.User;

public class NoUniqueBeanDefinitionExceptionDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);
		applicationContext.refresh();
		try {
			// 当有多个Bean的时候会抛出这个异常
			User bean = applicationContext.getBean(User.class);
		} catch (BeansException e) {
			System.err.println("当前不存在唯一的Bean:" + e.getMessage());
		}
		applicationContext.close();
	}

	@Bean
	public User user1() {
		return new User();
	}

	@Bean
	public User user2() {
		return new User();
	}

}
