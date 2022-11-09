package org.springframework.beandemo.factory;

import org.springframework.example.pojo.User;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/2 13:56
 * @description：
 * @modified By：
 * @version: $
 */
public interface UserFactory {
	default User createUser() {
		return User.createUser();
	}
}
