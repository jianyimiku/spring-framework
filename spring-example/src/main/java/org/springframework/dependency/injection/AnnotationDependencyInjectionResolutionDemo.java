package org.springframework.dependency.injection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.example.pojo.User;

import javax.inject.Inject;
import java.util.Map;

/**
 * 注解注入的依赖处理过程
 */
@ImportResource(value = "classpath:/META-INF/dependency/application-lookup.xml")
public class AnnotationDependencyInjectionResolutionDemo {


	@Autowired // 实时注入 + 通过类型依赖查找(处理) + 字段名称("user")
	private User user;

//	@Inject
//	private User user;

//	@Autowired // 集合类型的依赖注入
//	private Map<String, User> users;


	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);
		applicationContext.refresh();
		AnnotationDependencyInjectionResolutionDemo demo
				= applicationContext.getBean(AnnotationDependencyInjectionResolutionDemo.class);
		System.out.println(demo.user);
		applicationContext.close();

	}
}
