/*
 * @ (#) .java    1.0
 * Copyright (c)  IUH. All rights reserved.
 */
package iuh.fit.tuan01.levanhuuthai_2285411_tuan01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/*
 * @description
 * @author: Huu Thai
 * @date:
 * @version: 1.0
 */
@WebServlet(name = "bai5", value = "/bai-5")
public class Bai5 extends HttpServlet {
    private String name;
    private String username;
    private String email;
    private String password;
    private String facebook;
    private String shortBio;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        name = req.getParameter("first") + req.getParameter("last");
        username = req.getParameter("username");
        email = req.getParameter("email");
        password = req.getParameter("password");
        facebook = req.getParameter("facebook");
        shortBio = req.getParameter("shortBio");
        out.println("<html><body>");
        out.println("<h1>" + "Day la bai 5" + "</h1>");
        out.println("<h2> Name: " + name + "</h2>");
        out.println("<h2> Username: " + username + "</h2>");
        out.println("<h2> Email: " + email + "</h2>");
        out.println("<h2> Password: " + password + "</h2>");
        out.println("<h2> Facebook: " + facebook + "</h2>");
        out.println("<h2> Short bio: "  + shortBio + "</h2>");
        out.println("</body></html>");
    }

}
