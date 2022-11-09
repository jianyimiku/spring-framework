package org.springframework.example.dependency.inject;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.example.repoistory.UseRepository;

/**
 * @author ：sjq
 * @date ：Created in 2022/10/31 15:14
 * @description：依赖注入演示
 * @modified By：
 * @version: $
 */

public class DependencyInjectDemo {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext
				context = new ClassPathXmlApplicationContext("META-INF/application-inject.xml");
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
		UseRepository useRepository = beanFactory.getBean("userRepository", UseRepository.class);
		System.out.println(useRepository.getBeanFactory() == beanFactory);
		ObjectFactory<ApplicationContext> objectFactory = useRepository.getObjectFactory();
		System.out.println(objectFactory.getObject());
	}
}
