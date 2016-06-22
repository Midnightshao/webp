package com.springapp.mvc.project_discuss.entity;

import com.springapp.mvc.login.entity.Login;
import com.springapp.mvc.project.entity.project;

import javax.persistence.*;

/**
 * Created by guanghaoshao on 16/6/7.
 */
@Entity
@Table(name="project_discuss")
public class ProjectDiscuss {
    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name="content")
    private String content;
    @Column(name="image_type")
    private String image_type;
    @Column(name="name")
    private String name;
    @Column(name="time")
    private String time;
    @Column(name="rid_id")
    private String rid_id;
    public int getId() {
        return id;
    }

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private project pro;

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_type() {
        return image_type;
    }

    public void setImage_type(String image_type) {
        this.image_type = image_type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getRid_id() {
        return rid_id;
    }

    public void setRid_id(String rid_id) {
        this.rid_id = rid_id;
    }

    public project getPro() {
        return pro;
    }

    public void setPro(project pro) {
        this.pro = pro;
    }
}
