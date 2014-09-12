/**
 * 
 */
package org.zhubao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Jason.Zhu
 * @date 2014-7-24
 * @email jasonzhu@augmentum.com.cn
 */
@Data
@Entity(name = "User")
public class User {
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "userId", columnDefinition = "BINARY(16)")
	@Id
	private String userId;
	@Column(name = "username")
	private String username;
	@Column(name = "emailAddress")
	private String emailAddress;
	@Column(name = "password")
	private String password;
	@Column(name = "age")
	private int age;

}
