package org.springframework.dependency.injection;

import lombok.*;
import org.springframework.core.io.Resource;
import org.springframework.example.pojo.User;

import java.util.List;

/**
 * {@link User}的Holder类
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserHolder {
	private User user;
	private Resource configFileLocation;
	private String[] cities;
	private List<String> lifeCities;

	public UserHolder(User user) {
		this.user = user;
	}
}
