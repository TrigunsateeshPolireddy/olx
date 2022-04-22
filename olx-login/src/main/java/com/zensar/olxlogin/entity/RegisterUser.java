package com.zensar.olxlogin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private int phone;

}
