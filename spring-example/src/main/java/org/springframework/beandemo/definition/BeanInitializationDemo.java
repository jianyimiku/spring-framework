package org.springframework.beandemo.definition;

import org.springframework.beandemo.factory.DefaultUserFactory;
import org.springframework.beandemo.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/4 09:06
 * @description：Bean初始化
 * @modified By：
 * @version: $
 */
@Configuration
public class BeanInitializationDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(BeanInitializationDemo.class);
		applicationContext.refresh();
		UserFactory factory = applicationContext.getBean(UserFactory.class);
		System.out.println(factory.createUser());
		applicationContext.close();
	}


	@Bean(initMethod = "initUserFactory")
	@Lazy(value = true)
	public UserFactory userFactory() {
		return new DefaultUserFactory();
	}
}
