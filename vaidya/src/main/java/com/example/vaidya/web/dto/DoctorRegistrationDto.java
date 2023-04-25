package com.example.vaidya.web.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRegistrationDto {
    private String UserName;
    private String Full_Name;
    private String Government_Registration_Number;
    private int Age;
    private String Email;
    private String Phone_Number;
    private String  Doc_Password;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getFull_Name() {
		return Full_Name;
	}
	public void setFull_Name(String full_Name) {
		Full_Name = full_Name;
	}
	public String getGovernment_Registration_Number() {
		return Government_Registration_Number;
	}
	public void setGovernment_Registration_Number(String government_Registration_Number) {
		Government_Registration_Number = government_Registration_Number;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone_Number() {
		return Phone_Number;
	}
	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}
	public String getDoc_Password() {
		return Doc_Password;
	}
	public void setDoc_Password(String doc_Password) {
		Doc_Password = doc_Password;
	}

}
