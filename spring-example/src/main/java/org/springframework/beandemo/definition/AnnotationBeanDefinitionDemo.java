package org.springframework.beandemo.definition;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.example.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/2 11:08
 * @description：
 * @modified By：
 * @version: $
 */
@Import(AnnotationBeanDefinitionDemo.Config.class) // 通过@Import导入
public class AnnotationBeanDefinitionDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				applicationContext = new AnnotationConfigApplicationContext();
		// 注册配置类
//		applicationContext.register(Config.class);
		applicationContext.register(AnnotationBeanDefinitionDemo.class); // 需要@Import
		applicationContext.refresh();
		// 手动注册BeanDefinition
		registerUserBeanDefinition((BeanDefinitionRegistry) applicationContext.getBeanFactory(), "register-user");
		Map<String, Config> configMap = applicationContext.getBeansOfType(Config.class);
		Map<String, User> userMap = applicationContext.getBeansOfType(User.class);
		System.out.println("config所有实例:" + configMap);
		System.out.println("user所有实例:" + userMap);
		applicationContext.close();
	}


	/**
	 * 命名Bean的注册方式
	 *
	 * @param registry
	 * @param beanName
	 */
	public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
		BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class)
				.addPropertyValue("id", 2L)
				.addPropertyValue("name", "123");
		AbstractBeanDefinition beanDefinition = definitionBuilder.getBeanDefinition();
		if (StringUtils.hasText(beanName)) {
			registry.registerBeanDefinition(beanName, beanDefinition);
		} else {
			// 非命名注册方式
			BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
		}
	}


	/**
	 * 没有beanName传入复用上面的方法
	 * @param registry
	 */
	public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
		registerUserBeanDefinition(registry, null);
	}

	// 通过@Component方式
	@Component
	public static class Config {
		// 通过@Bean方式注入
		@Bean(name = {"user", "zs"})
		public User user() {
			User user = new User();
			user.setId(1L);
			return user;
		}
	}

}
