package com.example.vaidya.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.File;

//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
@Entity
@Table(name = "doctor_details")
public class Doctor {


    @Id
    @Column(name = "username")
    private String UserName;

    @Column(name = "Full_Name")
    private String Full_Name;

    @Column(name = "Government_Registration_Number")
    private String Government_Registration_Number;

    @Column(name = "Age")
    private int Age;

    @Column(name = "Email")
    private String Email;

    @Column(name = "Phone_Number")
    private String Phone_Number;

    @Column(name = "Doc_Password")
    private String Doc_Password;

    public Doctor(){

    }
    public Doctor(String userName, String full_Name, String government_Registration_Number, int age, String email, String phone_Number, String doc_Password) {
        UserName = userName;
        Full_Name = full_Name;
        Government_Registration_Number = government_Registration_Number;
        Age = age;
        Email = email;
        Phone_Number = phone_Number;
        Doc_Password = doc_Password;
    }

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
