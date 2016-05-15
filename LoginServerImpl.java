package com.springapp.mvc.login.server;

import com.springapp.mvc.login.dao.LoginDao;
import com.springapp.mvc.login.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guanghaoshao on 16/4/9.
 */
@Service
public class LoginServerImpl implements LoginServer{
    @Autowired
    LoginDao loginDao;

    @Override
    public boolean QueryLogin(HttpServletRequest request,Login login) {

        return loginDao.QueryLogin(request,login);
    }

    @Override
    public void DaoLogin(Login login) {
        loginDao.DaoLogin(login);
    }

    @Override
    public void DeleteLogin(Integer id) {

    }

    @Override
    public void UpdateLogin(Integer integer) {

    }

    @Override
    public boolean QueryUsername(Login login) {

        return loginDao.QueryUsername(login);
    }

    @Override
    public void SaveLogin(Login login) {
            loginDao.SaveLogin(login);
    }


}
