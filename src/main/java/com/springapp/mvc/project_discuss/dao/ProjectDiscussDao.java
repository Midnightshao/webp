package com.springapp.mvc.project_discuss.dao;

import com.springapp.mvc.project.entity.project;
import com.springapp.mvc.project_discuss.entity.ProjectDiscuss;

import java.util.List;

/**
 * Created by guanghaoshao on 16/5/30.
 */
public interface ProjectDiscussDao {
    public List<ProjectDiscuss> queryProjectDiscuss(int last_title,int project_id);
    public void saveProjectDiscuss(ProjectDiscuss pro, Integer integer);
    public void deleteProjectDiscuss();
    public void updateProjectDiscuss();
}
