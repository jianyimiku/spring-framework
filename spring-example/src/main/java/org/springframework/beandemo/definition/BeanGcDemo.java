package org.springframework.beandemo.definition;

import org.springframework.beandemo.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/4 10:10
 * @description：
 * @modified By：
 * @version: $
 */
public class BeanGcDemo {
	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext
				context = new AnnotationConfigApplicationContext();
		context.register(BeanInitializationDemo.class);
		context.refresh();
		UserFactory bean = context.getBean(UserFactory.class);
		context.close();
		bean=null;
		System.gc();
		Thread.sleep(5000);
	}
}
