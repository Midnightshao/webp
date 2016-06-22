package com.springapp.mvc.login.dao;

import com.springapp.mvc.login.entity.Login;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by guanghaoshao on 16/4/9.
 */
@Repository
public class LoginDaoImpl implements LoginDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean QueryLogin(HttpServletRequest request,Login login) {
        Query query= sessionFactory.openSession().createQuery("from  Login a where a.name=:name and a.password=:password");
        query.setString("name",login.getName());
        query.setString("password",login.getPassword());
        System.out.println(login.getName());
        System.out.println(login.getPassword());
        System.out.println(query.list());
        if(query.list().isEmpty()){
            return false;
        }else {
            Login login1= (Login) query.list().get(0);
            System.out.println(login1.getId()+"SessionId");
            request.getSession().setAttribute("id",login1.getId());
            return true;
        }
    }
    public boolean  QueryUsername(Login login){
        Query query=sessionFactory.openSession().createQuery("from Login a where a.name=:name");
        query.setString("name",login.getName());
        if(query.list().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void SaveLogin(Login login) {
        sessionFactory.openSession().save(login);
    }


    @Override
    public void DaoLogin(Login login) {
        sessionFactory.openSession().save(login);
    }

    @Override
    public void DeleteLogin(Integer id) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Login admin=(Login)session.load(Login.class,id);
        session.delete(admin);
        transaction.commit();
    }

    @Override
    public void UpdateLogin(Integer id) {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
    }


}
