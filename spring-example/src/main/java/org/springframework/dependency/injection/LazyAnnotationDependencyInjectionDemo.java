package org.springframework.dependency.injection;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ProviderCreatingFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.example.pojo.User;

import java.util.List;

/**
 * {@link org.springframework.beans.factory.ObjectProvider} 注解依赖注入 延迟注入
 */
@ImportResource(value = "classpath:/META-INF/dependency/application-lookup.xml")
public class LazyAnnotationDependencyInjectionDemo {

	/**
	 * 延迟注入
	 */
	@Autowired
	private ObjectProvider<User> provider;

	@Autowired
	private ObjectFactory<List<User>> userList;


	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(LazyAnnotationDependencyInjectionDemo.class);
		applicationContext.refresh();
		LazyAnnotationDependencyInjectionDemo demo
				= applicationContext.getBean(LazyAnnotationDependencyInjectionDemo.class);
		System.out.println(demo.provider.getIfAvailable());
		System.out.println(demo.userList.getObject());
		applicationContext.close();

	}
}
