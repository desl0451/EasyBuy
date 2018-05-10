package cn.easybuy.web.pre;

import cn.easybuy.entity.User;
import cn.easybuy.service.user.UserService;
import cn.easybuy.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/CheckUser"}, name = "CheckUser")
public class CheckUserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        User user = userService.findUserName(userName);
        String result = "";
        if (user == null) {
            result = "success";
        } else {
            result = "fail";
        }

        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
    }
}
