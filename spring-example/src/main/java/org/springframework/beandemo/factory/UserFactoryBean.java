package org.springframework.beandemo.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.example.pojo.User;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/2 14:01
 * @description：User的FactoryBean
 * @modified By：
 * @version: $
 */
public class UserFactoryBean implements FactoryBean<User> {
	@Override
	public User getObject() throws Exception {
		return User.createUser();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
