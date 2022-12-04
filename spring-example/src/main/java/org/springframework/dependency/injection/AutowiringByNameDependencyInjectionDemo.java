package org.springframework.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;


/**
 * ByName Autowiring 依赖 Setter方法注入
 */
public class AutowiringByNameDependencyInjectionDemo {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory
				= new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader
				= new XmlBeanDefinitionReader(beanFactory);
		DefaultResourceLoader defaultResourceLoader
				= new DefaultResourceLoader();
		Resource resource = defaultResourceLoader
				.getResource("classpath:/META-INF/injection/autowiring-application-setter-injection.xml");
		xmlBeanDefinitionReader.loadBeanDefinitions(resource);
		System.out.println(beanFactory.getBean(UserHolder.class));
	}
}
