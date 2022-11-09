package org.springframework.example.pojo;

/**
 * @author ：sjq
 * @date ：Created in 2022/10/31 15:16
 * @description：
 * @modified By：
 * @version: $
 */
public class User {
	private Long id;

	private String name;

	private static final User INSTANCE = new User();

	public static User createUser() {
		return INSTANCE;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name=" + name +
				'}';
	}
}
