package com.example.vaidya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
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
@Table(name="doctor_details")
public class DocLogin {
	@Id
//	@Column(name = "username")
	private String username;
	
//	@Column(name = "Doc_Password")
	private String Doc_Password;

	public String getUserName() {
		return this.username;
	}

	public void setUserName(String doc_UserName) {
		this.username = doc_UserName;
	}

	public String getDoc_Password() {
		return this.Doc_Password;
	}

	public void setDoc_Password(String doc_Password) {
		this.Doc_Password = doc_Password;
	}
	
	
	
 }
