package org.springframework.example.repoistory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.example.pojo.User;

import java.util.Collection;

/**
 * @author ：sjq
 * @date ：Created in 2022/10/31 16:55
 * @description：
 * @modified By：
 * @version: $
 */
public class UseRepository {
	private Collection<User> users;

	// 自动注入内建的非bean
	private BeanFactory beanFactory;

	private ObjectFactory<ApplicationContext> objectFactory;

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public ObjectFactory<ApplicationContext> getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
		this.objectFactory = objectFactory;
	}

	@Override
	public String toString() {
		return "UseRepository{" +
				"users=" + users +
				", beanFactory=" + beanFactory +
				'}';
	}
}
