package com.springapp.mvc.project_discuss.server;

import com.springapp.mvc.project.entity.project;
import com.springapp.mvc.project_discuss.dao.ProjectDiscussDao;
import com.springapp.mvc.project_discuss.entity.ProjectDiscuss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guanghaoshao on 16/6/7.
 */
@Service
public class ProjectDiscussServerImpl implements ProjectDiscussServer{
    @Autowired
    ProjectDiscussDao projectDiscussDao;
    @Override
    public List<ProjectDiscuss> queryProjectDiscuss(int last_title,int project_id) {

        return projectDiscussDao.queryProjectDiscuss(last_title,project_id);
    }

    @Override
    public void saveProjectDiscuss(ProjectDiscuss pro, Integer integer) {
        projectDiscussDao.saveProjectDiscuss(pro,integer);
    }

    @Override
    public void deleteProjectDiscuss() {

    }

    @Override
    public void updateProjectDiscuss() {

    }
}
