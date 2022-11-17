package org.springframework.dependency.lookup.exception;

import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanInstantiationExceptionDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(BeanInstantiationExceptionDemo.class);

		// 当Bean所对应的类型非具体类的时候
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(CharSequence.class);
		applicationContext.registerBeanDefinition("errorBean", beanDefinitionBuilder.getBeanDefinition());

		applicationContext.refresh();
		applicationContext.close();
	}


}
