package org.springframework.dependency.injection.annotation;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;

public class MyAutowireAnnotationBeanPostProcessor extends AutowiredAnnotationBeanPostProcessor {
	public MyAutowireAnnotationBeanPostProcessor() {
		super();
		this.setAutowiredAnnotationType(AutowireInjectd.class);
	}
}