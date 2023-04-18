package com.example.atividade2;

import com.example.atividade2.service.LoginService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import  jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    String user = req.getParameter("field_user");
    String password = req.getParameter("field_password");

    LoginService service = new LoginService();

    try{
        service.validateLogin(user, password, req);

        resp.sendRedirect("http://localhost:8080/login/pagina.jsp");

    } catch (Exception e) {

        String msg = e.getMessage();
        resp.sendRedirect("http://localhost:8080/login/index.jsp?msg=" + msg);
    }
}

}
