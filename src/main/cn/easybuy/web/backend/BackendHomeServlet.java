package cn.easybuy.web.backend;

import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/BackendHome"}, name = "BackendHome")
public class BackendHomeServlet extends AbstractServlet {

    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "backend/admin";
    }

    @Override
    public Class getServletClass() {
        return BackendHomeServlet.class;
    }
}
