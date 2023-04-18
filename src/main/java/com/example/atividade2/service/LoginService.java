package com.example.atividade2.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginService {

    public void validateLogin(String user, String password, HttpServletRequest req) throws Exception {

        if(user == null || user.isEmpty()){
            throw new Exception("Usuario invalido");
        }
        if(password == null || password.isEmpty()){
            throw new Exception("Senha invalido");
    }


        if(user.equals("admin") && password.equals("admin")){

            HttpSession session = req.getSession();

            session.setAttribute("isLoggedIn", true);
            session.setAttribute("user", user);

        }
        else {
            throw new Exception("Usuario ou senha incorretos");
    }
    }
}
