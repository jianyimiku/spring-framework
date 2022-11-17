package org.springframework.dependency.lookup.exception;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

/**
 * Bean创建时候异常
 */
public class BeanCreationExceptionDemo implements InitializingBean {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(BeanCreationExceptionDemo.class);
		applicationContext.refresh();
		applicationContext.close();
	}

	@PostConstruct //CommonAnnotationPostProcessor
	public void init() {
		throw new RuntimeException("PostConstruct Exception");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		throw new Exception("创建异常");
	}
}
