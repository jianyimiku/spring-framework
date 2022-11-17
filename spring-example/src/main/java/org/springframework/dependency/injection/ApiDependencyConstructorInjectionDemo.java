package org.springframework.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;


/**
 * 基于XML资源的依赖Setter方法注入
 */
@ImportResource(value = "classpath:/META-INF/dependency/application-lookup.xml")
public class ApiDependencyConstructorInjectionDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ApiDependencyConstructorInjectionDemo.class);
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) applicationContext.getBeanFactory();
		registry.registerBeanDefinition("userHolder", createUserHolderBeanDefinition());
		applicationContext.refresh();
		System.out.println(applicationContext.getBean(UserHolder.class));
		applicationContext.close();
	}


	/**
	 * 为UserHolder生成BeanDefinition
	 *
	 * @return
	 */
	private static BeanDefinition createUserHolderBeanDefinition() {
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
		return beanDefinitionBuilder
				// 因为构造器参数执行的顺序是一定的 和 setter不同setter是不确定的所以setter是需要设置名称的
				.addConstructorArgReference("user")
				.getBeanDefinition();
	}
}
