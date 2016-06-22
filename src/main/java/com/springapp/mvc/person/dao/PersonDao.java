package com.springapp.mvc.person.dao;

import com.springapp.mvc.login.entity.Login;
import com.springapp.mvc.person.entity.person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by guanghaoshao on 16/4/9.
 */
public interface PersonDao {
    public boolean PersonLogin(person person);
    public void PersonDao(person person);
    public void PersonDelete(Integer id);
    public void PersonUpdate(person person);
    public void PersonImage(Integer integer,String image_type);
    public List PersonQuery(String rid_id);
    public void PersonSave(person person);
    public boolean PersonQueryUser(String rid_id);
}
