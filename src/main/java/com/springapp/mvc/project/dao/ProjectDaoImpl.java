package com.springapp.mvc.project.dao;

import com.springapp.mvc.login.entity.Login;
import com.springapp.mvc.project.entity.project;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by guanghaoshao on 16/5/30.
 */
@Repository
public class ProjectDaoImpl implements ProjectDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<project> queryProject(int last_title) {
        Query query=sessionFactory.openSession().createQuery("from project");
        int last=8;
        int listSize=query.list().size();
        query.setFirstResult(listSize-last*last_title);
        query.setMaxResults(listSize);
        List<project> list=query.list();
        return list;
    }

    @Override
    public void saveProject(project pro,Integer integer) {
        Session session=sessionFactory.openSession();
        Login login=(Login)session.load(Login.class,integer);
        login.getPersons().add(pro);
        pro.setProject(login);
        System.out.println(pro.getName() + "   " + pro.getContent() + "   " + pro.getImage_type());
        session.save(pro);
    }

    @Override
    public void deleteProject() {
    }

    @Override
    public void updateProject() {

    }
}
