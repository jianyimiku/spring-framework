package org.springframework.beandemo.definition;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/1 15:44
 * @description：Bean别名示例
 * @modified By：
 * @version: $
 */
public class BeanAliasDemo {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext
				applicationContext = new ClassPathXmlApplicationContext("META-INF/bean-definition-context.xml");
		// 使用别名进行查找
		System.out.println(applicationContext.getBean("zs"));
	}
}
