package com.springapp.mvc.project_discuss.dao;

import com.springapp.mvc.login.entity.Login;
import com.springapp.mvc.project.entity.project;
import com.springapp.mvc.project_discuss.entity.ProjectDiscuss;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by guanghaoshao on 16/5/30.
 */
@Repository
public class ProjectDiscussDaoImpl implements ProjectDiscussDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ProjectDiscuss> queryProjectDiscuss(int last_title,int project_id) {

        Query query=sessionFactory.openSession().createSQLQuery("SELECT  * from project_discuss a where a.project_id=:project_id").addEntity(ProjectDiscuss.class);
        query.setInteger("project_id",project_id);
        int lastSize=last_title*8;
        query.setFirstResult(1);
        query.setMaxResults(lastSize);
        List<ProjectDiscuss> list=query.list();
        System.out.println(list);
        return list;
    }

    @Override
    public void saveProjectDiscuss(ProjectDiscuss pro, Integer integer) {
        Session session=sessionFactory.openSession();
        project project=(project)session.load(project.class,integer);
        project.getPersons().add(pro);
        pro.setPro(project);
        session.save(pro);
    }

    @Override
    public void deleteProjectDiscuss() {

    }

    @Override
    public void updateProjectDiscuss() {

    }
}
