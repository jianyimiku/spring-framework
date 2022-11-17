package org.springframework.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/4 16:49
 * @description：层次性依赖查找
 * @modified By：
 * @version: $
 */
public class HierarchialDependencyLookUp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ObjectProviderDemo.class);
		applicationContext.refresh();
		// ConfigurableListableBeanFactory -> ConfigurableBeanFactory -> HierarchicalBeanFactory
		ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
		beanFactory.setParentBeanFactory(createParentBeanFactory());
		disPlayContainsLocalBean(beanFactory, "user");
		disPlayBean(beanFactory, "user");
		// 设置ParentBeanFactory
		applicationContext.close();
	}

	private static void disPlayBean(HierarchicalBeanFactory beanFactory, String beanName) {
		System.out.println(containsBean(beanFactory, beanName));
	}

	private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {
		BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
		if (parentBeanFactory instanceof HierarchicalBeanFactory) {
			HierarchicalBeanFactory parent = HierarchicalBeanFactory.class.cast(parentBeanFactory);
			// 递归判断父类有没有
			if (containsBean(parent, beanName)) {
				return true;
			}
		}
		return beanFactory.containsBean(beanName);
	}

	private static void disPlayContainsLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {
		// false
		System.out.println(beanFactory.containsLocalBean(beanName));
	}

	private static BeanFactory createParentBeanFactory() {
		ClassPathXmlApplicationContext
				context = new ClassPathXmlApplicationContext("META-INF/dependency/application-lookup.xml");
		return context.getBeanFactory();
	}
}
