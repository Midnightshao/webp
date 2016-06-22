package com.springapp.mvc.login.entity;

import com.springapp.mvc.person.entity.person;
import com.springapp.mvc.project.entity.project;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by guanghaoshao on 16/4/9.
 */
@Entity
@Table(name="admin")
public class Login implements java.io.Serializable{

    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy="project")
    private Set<project> persons = new HashSet<project>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<project> getPersons() {
        return persons;
    }

    public void setPersons(Set<project> persons) {
        this.persons = persons;
    }
}
