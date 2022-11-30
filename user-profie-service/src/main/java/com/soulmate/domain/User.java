package com.soulmate.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.util.Date;


@Document(collection = "userDB")
@Data
public class User {
    private String name;
    @Id
    private String email;
    private Long phoneNo;
    private String password;
    private String address;
    private Date dob;
    private String gender;
    private String picture;

    public User() {
    }

    public User(String name, String email, Long phoneNo, String password, String address, Date dob, String gender,  String picture) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.picture = picture;
    }
}
