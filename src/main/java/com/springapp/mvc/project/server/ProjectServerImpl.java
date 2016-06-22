package com.springapp.mvc.project.server;

import com.springapp.mvc.project.dao.ProjectDao;
import com.springapp.mvc.project.dao.ProjectDaoImpl;
import com.springapp.mvc.project.entity.project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guanghaoshao on 16/5/30.
 */
@Service
public class ProjectServerImpl implements ProjectServer{
    @Autowired
    private ProjectDao projectDao;
    @Override
    public List<project> queryProject(int last_title) {
        return projectDao.queryProject(last_title);
    }

    @Override
    public void saveProject(project project,Integer integer) {
        projectDao.saveProject(project,integer);
    }

    @Override
    public void deleteProject() {

    }

    @Override
    public void updateProject() {

    }
}
