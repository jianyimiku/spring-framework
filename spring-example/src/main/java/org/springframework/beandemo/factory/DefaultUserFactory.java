package org.springframework.beandemo.factory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/2 14:09
 * @description：
 * @modified By：
 * @version: $
 */
public class DefaultUserFactory implements UserFactory, InitializingBean {
	// 基于@PostConstruct
	@PostConstruct
	public void init() {
		System.out.println("@PostConstruct UserFactory 初始化");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean:afterPropertiesSet");
	}

	public void initUserFactory() {
		System.out.println("自定义初始化方法:initUserFactory");
	}


	@Override
	public void finalize() throws Throwable {
		System.out.println("当前DefaultUserFactory正在被回收");
	}
}
