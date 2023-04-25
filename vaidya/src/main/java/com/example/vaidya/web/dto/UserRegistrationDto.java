package com.example.vaidya.web.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
//@NoArgsConstructor
@Setter
@Getter

public class UserRegistrationDto {


    private String username;

    private String fullname;

    private String phone_num;

    private int age;

    private String passsword;

    private String gender;

    private String email;


    public UserRegistrationDto(String username, String fullname, String phone_num, int age, String passsword,
                               String gender, String email) {
        super();
        this.username = username;
        this.fullname = fullname;
        this.phone_num = phone_num;
        this.age = age;
        this.passsword = passsword;
        this.gender = gender;
        this.email = email;
    }

    public UserRegistrationDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}

