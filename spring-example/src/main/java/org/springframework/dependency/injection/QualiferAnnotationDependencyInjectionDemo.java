package org.springframework.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.dependency.injection.annotation.UserGroup;
import org.springframework.example.pojo.User;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Locale;


/**
 * 基于字段的注入方式
 */
@ImportResource(value = "classpath:/META-INF/dependency/application-lookup.xml")
public class QualiferAnnotationDependencyInjectionDemo {
	@Autowired
	@Qualifier
	public User user1;

	@Autowired
	@Qualifier
	public User user2;

	@Autowired
	private Collection<User> users;

	@Autowired
	@Qualifier //Qualifier分组
	private Collection<User> usersQualifer;

	@Autowired
	@UserGroup
	private Collection<User> userGroup;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(QualiferAnnotationDependencyInjectionDemo.class);
		applicationContext.refresh();
		QualiferAnnotationDependencyInjectionDemo demo
				= applicationContext.getBean(QualiferAnnotationDependencyInjectionDemo.class);
		//[User{id=null, name=user1}, User{id=null, name=user2}]
		//[User{id=1, name=zs}, SuperUser{address='123414'} User{id=1, name=zs}]
		System.out.println(demo.usersQualifer);
		System.out.println(demo.userGroup);
		System.out.println(demo.users);
		applicationContext.close();
	}

	@Bean
	@Qualifier
	public User user1() {
		return createUser(7L);
	}

	@Bean
	@Qualifier
	public User user2() {
		return createUser(8L);
	}

	@Bean
	@UserGroup
	public User user3() {
		return createUser(9L);
	}


	private static User createUser(Long id) {
		User user = new User();
		user.setId(id);
		return user;
	}

}
