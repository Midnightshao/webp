package com.springapp.mvc.login.dao;

import com.springapp.mvc.login.entity.Login;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guanghaoshao on 16/4/9.
 */
public interface LoginDao {
    public boolean QueryLogin(HttpServletRequest request,Login login);
    public void DaoLogin(Login login);
    public void DeleteLogin(Integer id);
    public void UpdateLogin(Integer integer);
    public boolean QueryUsername(Login login);
    public void SaveLogin(Login login);
}
