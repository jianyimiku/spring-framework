package org.springframework.example.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.example.annotation.Super;
import org.springframework.example.pojo.User;

import java.util.Map;

/**
 * @author ：sjq
 * @date ：Created in 2022/10/31 15:14
 * @description：依赖查找演示
 * @modified By：
 * @version: $
 */

public class DependencyLookUpDemo {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext
				context = new ClassPathXmlApplicationContext("META-INF/application-lookup.xml");
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
//		lookupInLazy(beanFactory);
		lookUpByAnnotationType(beanFactory);
	}

	private static void lookupInLazy(BeanFactory beanFactory) {
		ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("factoryDemo");
		User object = objectFactory.getObject();
		System.out.println("延迟查找:" + object);
	}

	private static void lookUpByAnnotationType(BeanFactory factory) {
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) factory;
		Map<String, Object> beansWithAnnotation = beanFactory.getBeansWithAnnotation(Super.class);
		System.out.println(beansWithAnnotation);
	}


	private static void lookupInRealTime(BeanFactory beanFactory) {
		System.out.println(beanFactory.getBean("user", User.class));
	}
}
