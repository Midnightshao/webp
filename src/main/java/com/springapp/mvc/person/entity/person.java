package com.springapp.mvc.person.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by guanghaoshao on 16/4/9.
 */
@Entity
@Table(name="person")
public class person implements java.io.Serializable{

    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;

    @Column(name="name")
    private  String name;

    @Column(name="age")
    private  int age;

    @Column(name="email")
    private  String email;

    @Column(name="address")
    private  String  address;

    @Column(name="github")
    private  String  github;

    @Column(name="image_type")
    private  String  image_type;

    @Column(name="rid_id")
    private  int  rid_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImage_type() {
        return image_type;
    }

    public void setImage_type(String image_type) {
        this.image_type = image_type;
    }

    public int getRid_id() {
        return rid_id;
    }

    public void setRid_id(int rid_id) {
        this.rid_id = rid_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}
