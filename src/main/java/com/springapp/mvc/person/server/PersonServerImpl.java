package com.springapp.mvc.person.server;

import com.springapp.mvc.login.dao.LoginDao;
import com.springapp.mvc.login.entity.Login;
import com.springapp.mvc.login.server.*;
import com.springapp.mvc.login.server.LoginServer;
import com.springapp.mvc.person.dao.PersonDao;
import com.springapp.mvc.person.dao.PersonDaoImpl;
import com.springapp.mvc.person.entity.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guanghaoshao on 16/4/9.
 */
@Service
public class PersonServerImpl implements PersonServer {
    @Autowired
    private PersonDao personDao;

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
        personDao.PersonUpdate(person);
    }

    @Override
    public void PersonImage(Integer integer, String image_type) {
        personDao.PersonImage(integer,image_type);
    }

    @Override
    public List PersonQuery(String rid_id) {
        return personDao.PersonQuery(rid_id);
    }
    @Override
    public void PersonSave(person person) {
        personDao.PersonSave(person);
    }

    @Override
    public boolean PersonQueryUser(String rid_id) {

        return personDao.PersonQueryUser(rid_id);
    }
}
