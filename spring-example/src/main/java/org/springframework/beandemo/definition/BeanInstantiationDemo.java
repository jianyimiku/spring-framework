package org.springframework.beandemo.definition;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/2 13:48
 * @description：
 * @modified By：
 * @version: $
 */
public class BeanInstantiationDemo {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/dependency/bean-instantiation-context.xml");
		System.out.println(context.getBean("user-by-factory-bean"));
	}
}
