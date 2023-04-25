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


@Entity
@Table(name = "user_details")
public class User {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phone_num")
    private String phone_num;

    @Column(name = "age")
    private int age;

    @Column(name = "passsword")
    private String passsword;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    public User() {

    }

    public User(String username, String fullname, String phone_num, int age, String passsword, String gender,
                String email) {
        super();
        this.username = username;
        this.fullname = fullname;
        this.phone_num = phone_num;
        this.age = age;
        this.passsword = passsword;
        this.gender = gender;
        this.email = email;
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
