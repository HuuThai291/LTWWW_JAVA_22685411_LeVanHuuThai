package iuh.fit.tuan01.levanhuuthai_2285411_tuan01;

import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.tuan01.levanhuuthai_2285411_tuan01.model.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "bai3", value = "/bai-3")
public class Bai3 extends HttpServlet {
    private String message;
    private User user;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        message = "Day la bai 3";
        user = new User(1, "HuuThai", "thai@gmail.com");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        resp.getWriter().write(json);
    }
}
