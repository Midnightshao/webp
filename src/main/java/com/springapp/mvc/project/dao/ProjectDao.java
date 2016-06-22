package com.springapp.mvc.project.dao;

import com.springapp.mvc.project.entity.project;

import java.util.List;

/**
 * Created by guanghaoshao on 16/5/30.
 */
public interface ProjectDao {
    public List<project> queryProject(int last_title);
    public void saveProject(project pro,Integer integer);
    public void deleteProject();
    public void updateProject();
}
