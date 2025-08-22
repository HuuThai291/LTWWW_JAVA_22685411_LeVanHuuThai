package iuh.fit.tuan01.levanhuuthai_2285411_tuan01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "bai2", urlPatterns = "/bai-2")
public class Bai2 extends HttpServlet {
    private String message1;
    private String message2;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        message1 = "Hello world";
        message2 = "Day la bai 2";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message1 + "</h1>");
        out.println("<h2>" + message2 + "</h2>");
        out.println("</body></html>");

        out.flush();
        out.close();
    }
}
