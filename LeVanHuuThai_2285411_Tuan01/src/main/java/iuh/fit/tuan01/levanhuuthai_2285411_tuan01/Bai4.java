package iuh.fit.tuan01.levanhuuthai_2285411_tuan01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
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
@WebServlet(name = "bai4", value = "/bai-4", initParams = {
        @WebInitParam(name = "username", value = "thai"),

})
public class Bai4 extends HttpServlet {
    private String message;
    private String username;
    private String email;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        message = "Day la bai 4";
//        Dung init-param
        username = config.getInitParameter("username");
        email = config.getInitParameter("email");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h2>" + "Username: " + username + "</h2>");
        out.println("<h2>" + "Email: " + email + "</h2>");
//        Dung context param
        out.println("<h2>" + "Context param: " + this.getServletContext().getInitParameter("context-param") + "</h2>");
        out.println("</body></html>");

        out.flush();
        out.close();
    }
}
