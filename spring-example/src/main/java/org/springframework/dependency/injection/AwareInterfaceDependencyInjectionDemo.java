package org.springframework.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;


/**
 * 基于 {@link org.springframework.beans.factory.Aware}  回调依赖注入
 */
public class AwareInterfaceDependencyInjectionDemo implements BeanFactoryAware, ApplicationContextAware {
	public static BeanFactory beanFactory;

	public static ApplicationContext applicationContext;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext
				= new AnnotationConfigApplicationContext();
		applicationContext.register(AwareInterfaceDependencyInjectionDemo.class);

		applicationContext.refresh();

		System.out.println(beanFactory == applicationContext.getBeanFactory());
		System.out.println(AwareInterfaceDependencyInjectionDemo.applicationContext == applicationContext);

		applicationContext.close();
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		AwareInterfaceDependencyInjectionDemo.beanFactory = beanFactory;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		AwareInterfaceDependencyInjectionDemo.applicationContext = applicationContext;
	}
}
