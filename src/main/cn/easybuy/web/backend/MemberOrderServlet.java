package cn.easybuy.web.backend;

import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/MemberOrder", name = "MemberOrder")
public class MemberOrderServlet extends AbstractServlet {

    public String toFindOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "backend/order/memberOrder";
    }


    @Override
    public Class getServletClass() {
        return MemberOrderServlet.class;
    }
}
