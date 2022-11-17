package org.springframework.dependency.injection;

import lombok.*;
import org.springframework.example.pojo.User;

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
}
