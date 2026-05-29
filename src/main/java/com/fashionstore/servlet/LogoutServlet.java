package com.fashionstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
                         throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();


        // Get Session

        HttpSession session =
                req.getSession(false);


        // Destroy Session

        if(session != null) {

            session.invalidate();
        }


        out.println("<h1>Logout Successful</h1>");
    }
}