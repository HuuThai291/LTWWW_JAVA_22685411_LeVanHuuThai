package fit.iuh.edu.levanhuuthai_22685411_tuan02.bai1;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

@WebFilter(urlPatterns = { "*.png", "*.jpg", "*.jpeg", "*.gif" },
        initParams = {
                @WebInitParam(name = "notFoundImage", value = "/images/image_not_found.jpg")
        }
)
public class ImageFilter extends HttpFilter implements Filter {
    private String imageNotFoundPath;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.imageNotFoundPath = filterConfig.getInitParameter("notFoundImage");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        // Đường dẫn tuyệt đối của thư mục gốc của WebApp (WebContent).
        String realRootPath = req.getServletContext().getRealPath("");

        String servletPath = req.getServletPath();
        // Đường dẫn tuyệt đối tới file ảnh.
        String imageRealPath = realRootPath + servletPath;

        System.out.println("imageRealPath = " + imageRealPath);

        File file = new File(imageRealPath);
        // Kiểm tra xem ảnh có tồn tại không
        if (file.exists()) {
            // Cho phép request được đi tiếp
            // (Để đi tiếp tới file ảnh yêu cầu)
            chain.doFilter(req, res);
        } else if (!servletPath.equals(this.imageNotFoundPath)) {
            // Redirect (Chuyển hướng) tới file ảnh 'image-not-found.png'.
            res.sendRedirect(req.getContextPath() + this.imageNotFoundPath);
        }
    }
}
