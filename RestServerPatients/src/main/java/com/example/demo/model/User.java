package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@NonNull
	private String username;
	private String name;
	private String lastName;
	@NonNull
	private char[] password;
	private String state;
	
	public User (String login,String password) {
		this.username = login;
		char[] pass = password.toCharArray();
		this.password = pass;
	}
}
