package com.springapp.mvc.person.dao;

import com.springapp.mvc.login.dao.*;
import com.springapp.mvc.login.dao.LoginDao;
import com.springapp.mvc.login.entity.Login;
import com.springapp.mvc.person.entity.person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by guanghaoshao on 16/4/9.
 */
@Repository
public class PersonDaoImpl implements PersonDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public boolean PersonLogin(person person) {
        return false;
    }

    @Override
    public void PersonDao(person person) {

    }

    @Override
    public void PersonDelete(Integer id) {

    }

    @Override
    public void PersonUpdate(person person) {
        System.out.println("更新1111111111");

        Session session= sessionFactory.openSession();

        Query query=session.createQuery("from person a where a.rid_id=:rid_id");

        query.setInteger("rid_id",person.getRid_id());

        person person_user= (com.springapp.mvc.person.entity.person) query.list().get(0);

        Session session1=sessionFactory.openSession();

        person_user.setGithub(person.getGithub());
        person_user.setAddress(person.getAddress());
        person_user.setEmail(person.getEmail());
        person_user.setAge(person.getAge());
        person_user.setName(person.getName());
        session1.update(person_user);
        session.flush();
    }

    public void PersonImage(Integer integer,String image_type) {


        Session session= sessionFactory.openSession();

        Query query=session.createQuery("from person a where a.rid_id=:rid_id");

        query.setInteger("rid_id",integer);

        person person_user= (com.springapp.mvc.person.entity.person) query.list().get(0);

        Session session1=sessionFactory.openSession();

        person_user.setImage_type(image_type);

        session1.update(person_user);

        session.flush();
    }

    @Override
    public List PersonQuery(String rid_id) {

        Query query=sessionFactory.openSession().createQuery("from  person a where a.rid_id=:rid_id");
        query.setInteger("rid_id", Integer.valueOf(rid_id));
        return query.list();
    }

    @Override
    public void PersonSave(person person) {
        //好天气
        sessionFactory.openSession().save(person);
    }

    @Override
    public boolean PersonQueryUser(String rid_id) {
        Query query=sessionFactory.openSession().createQuery("from  person a where a.rid_id=:rid_id");
        query.setInteger("rid_id", Integer.valueOf(rid_id));
        if(query.list().isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}

