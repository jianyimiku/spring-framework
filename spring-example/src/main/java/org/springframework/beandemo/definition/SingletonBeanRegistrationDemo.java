package org.springframework.beandemo.definition;

import org.springframework.beandemo.factory.DefaultUserFactory;
import org.springframework.beandemo.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/4 10:28
 * @description：
 * @modified By：
 * @version: $
 */
public class SingletonBeanRegistrationDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				context = new AnnotationConfigApplicationContext();
		// 注册外部单例对象
		UserFactory userFactory = new DefaultUserFactory();
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		beanFactory.registerSingleton("user", userFactory);
		context.refresh();
		UserFactory bean = context.getBean(UserFactory.class);
		context.close();
	}
}
