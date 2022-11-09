package org.springframework.beandemo.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.example.pojo.User;


/**
 * @author ：sjq
 * @date ：Created in 2022/11/1 14:40
 * @description：BeanDefinition构建实例
 * @modified By：
 * @version: $
 */
public class BeanDefinitionCreationDemo {
	public static void main(String[] args) {
	}


	private static BeanDefinition createBeanDefinitionBuilder() {
		return BeanDefinitionBuilder.genericBeanDefinition(User.class)
				.addPropertyValue("id", 1L)
				.addPropertyValue("name", "123")
				.setScope(BeanDefinition.SCOPE_SINGLETON)
				.getBeanDefinition();
	}

	private static BeanDefinition createBeanDefinitionByAbstractBeanDefinition() {
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(User.class);
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue("id", 1L);
		propertyValues.addPropertyValue("name", "123");
		beanDefinition.setPropertyValues(propertyValues);
		return beanDefinition;
	}
}
