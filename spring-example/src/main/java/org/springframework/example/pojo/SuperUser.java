package org.springframework.example.pojo;

import org.springframework.example.annotation.Super;

/**
 * @author ：sjq
 * @date ：Created in 2022/10/31 16:43
 * @description：
 * @modified By：
 * @version: $
 */
@Super
public class SuperUser extends User{
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SuperUser{" +
				"address='" + address + '\'' +
				"} " + super.toString();
	}
}
