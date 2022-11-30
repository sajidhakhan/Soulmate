package com.soulmatebackend.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Document
@Data
@Entity
public class User {

    private String name;
    private int age;
    private String gender;
    private String city;
    @Id
    private String email;
    @Transient
    private String password;
    private String picture;

    public User() {
    }

    public User(String name, int age, String gender, String city, String email, String password, String picture) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.email = email;
        this.password = password;
        this.picture = picture;
    }
}
