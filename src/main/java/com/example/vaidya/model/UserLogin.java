package com.example.vaidya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.context.annotation.Primary;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user_details")
public class UserLogin {

	@Id
	private String username;
	
	private String passsword;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasssword() {
		return passsword;
	}
	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
	
	
	
 }
