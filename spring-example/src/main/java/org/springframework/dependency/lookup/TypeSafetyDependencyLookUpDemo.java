package org.springframework.dependency.lookup;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.example.pojo.User;

import java.util.Map;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/8 16:27
 * @description：类型安全依赖查找实例
 * @modified By：
 * @version: $
 */
public class TypeSafetyDependencyLookUpDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext
				= new AnnotationConfigApplicationContext();
		applicationContext.register(TypeSafetyDependencyLookUpDemo.class);

		applicationContext.refresh();
		// 演示各种方法安全性 延迟查找推荐使用ObjectProvider
		disPlayBeanFactoryGetBean(applicationContext.getBeanFactory());
		disPlayObjectFactoryGetObject(applicationContext.getBeanFactory());
		disPlayObjectProviderGetIfAvailable(applicationContext.getBeanFactory());
		disPlayListableBeanFactoryGetBeansOfType(applicationContext.getBeanFactory());
		applicationContext.close();
	}

	private static void disPlayListableBeanFactoryGetBeansOfType(ConfigurableListableBeanFactory beanFactory) {
		Map<String, User> beansOfType = beanFactory.getBeansOfType(User.class);
		System.err.println(beansOfType);
	}

	private static void disPlayObjectProviderGetIfAvailable(BeanFactory beanFactory) {
		ObjectProvider<User> provider = beanFactory.getBeanProvider(User.class);
		User user = provider.getIfAvailable();
		System.err.println(user);
	}

	private static void disPlayObjectFactoryGetObject(BeanFactory beanFactory) {
		ObjectFactory<User> factory = beanFactory.getBeanProvider(User.class);
		try {
			factory.getObject();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

	public static void disPlayBeanFactoryGetBean(BeanFactory beanFactory) {
		try {
			beanFactory.getBean(User.class);
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
}
