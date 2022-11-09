package org.springframework.example.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.example.pojo.User;

import java.util.Arrays;
import java.util.Map;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/1 11:57
 * @description：注解能力 {@link org.springframework.context.ApplicationContext} 作为IOC容器实例
 * @modified By：
 * @version: $
 */
public class AnnotationApplicationContextAsIoCContainer {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext();
		// 将当前类作为配置类
		applicationContext.register(AnnotationApplicationContextAsIoCContainer.class);
		// 启动Application
		applicationContext.refresh();
//		lookUpCollectionByType(applicationContext.getBeanFactory());
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
		System.out.println(Arrays.toString(beanFactory.getBeanDefinitionNames()));
		Map<String, User> beansOfType = beanFactory.getBeansOfType(User.class);
		System.out.println(beansOfType);
		applicationContext.close();
	}


	@Bean
	public UserFactoryBean userFactoryBean() {
		return new UserFactoryBean();
	}

	public static class UserFactoryBean implements FactoryBean<User> {
		private User user;

		@Override
		public User getObject() throws Exception {
			return createSingleTonUser();
		}


		private synchronized User createSingleTonUser() {
			if (user == null) {
				User user = new User();
				user.setId(1L);
				this.user = user;
			}
			return user;
		}


		@Override
		public Class<?> getObjectType() {
			return User.class;
		}
	}

	private static void lookUpCollectionByType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			DefaultListableBeanFactory listableBeanFactory = (DefaultListableBeanFactory) beanFactory;
			Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
			System.out.println(beansOfType);
		}
	}
}
