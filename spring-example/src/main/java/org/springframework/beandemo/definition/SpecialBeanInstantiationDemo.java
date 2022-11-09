package org.springframework.beandemo.definition;

import org.springframework.beandemo.factory.DefaultUserFactory;
import org.springframework.beandemo.factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/2 13:48
 * @description：特殊的Bean实例化
 * @modified By：
 * @version: $
 */
public class SpecialBeanInstantiationDemo {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context
				= new ClassPathXmlApplicationContext("META-INF/special-bean-instantiation-context.xml");
		AutowireCapableBeanFactory autowireCapableBeanFactory = context.getAutowireCapableBeanFactory();
		// 通过AutowireCapableBeanFactory来创建对象
		UserFactory userFactory = autowireCapableBeanFactory.createBean(DefaultUserFactory.class);
		System.out.println(userFactory.createUser());
	}

	private static void extracted(ClassPathXmlApplicationContext context) {
		ServiceLoader<UserFactory> serviceLoader = context.getBean("userFactoryServiceLoader", ServiceLoader.class);
		extracted(serviceLoader);
	}


	private static void demoServiceLoader() {
		ClassPathXmlApplicationContext context
				= new ClassPathXmlApplicationContext("META-INF/special-bean-instantiation-context.xml");
		ServiceLoader<UserFactory> load = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
		extracted(load);
	}

	private static void extracted(ServiceLoader<UserFactory> load) {
		Iterator<UserFactory> iterator = load.iterator();
		while (iterator.hasNext()) {
			UserFactory userFactory = iterator.next();
			System.out.println(userFactory.getClass().getName());
		}
	}
}
