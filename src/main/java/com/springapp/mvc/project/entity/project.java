package com.springapp.mvc.project.entity;

import com.springapp.mvc.login.entity.Login;
import com.springapp.mvc.person.entity.person;
import com.springapp.mvc.project_discuss.entity.ProjectDiscuss;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by guanghaoshao on 16/5/30.
 */
@Entity
@Table(name="project")
public class project{
    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="image_type")
    private String image_type;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;


    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "rid_id")
    private Login project;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy="pro")
    private Set<ProjectDiscuss> persons = new HashSet<ProjectDiscuss>();

    public String getImage_type() {
        return image_type;
    }

    public void setImage_type(String image_type) {
        this.image_type = image_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Login getProject() {
        return project;
    }

    public void setProject(Login project) {
        this.project = project;
    }

    public Set<ProjectDiscuss> getPersons() {
        return persons;
    }

    public void setPersons(Set<ProjectDiscuss> persons) {
        this.persons = persons;
    }
}
