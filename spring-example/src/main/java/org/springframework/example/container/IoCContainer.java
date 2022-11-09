package org.springframework.example.container;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.util.Arrays;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/1 11:48
 * @description：IOC容器实例
 * @modified By：
 * @version: $
 */
public class IoCContainer {
	public static void main(String[] args) {
		// 创建BeanFactory容器
		DefaultListableBeanFactory beanFactory
				= new DefaultListableBeanFactory();
		XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
		Resource resource = defaultResourceLoader.getResource("classpath:/META-INF/application-inject.xml");
		beanDefinitionReader.loadBeanDefinitions(resource);
		Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(
				data -> System.out.println(beanFactory.getBeanDefinition(data))
		);
	}
}
