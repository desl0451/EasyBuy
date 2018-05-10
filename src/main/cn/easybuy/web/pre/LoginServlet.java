package cn.easybuy.web.pre;

import cn.easybuy.entity.User;
import cn.easybuy.service.user.UserService;
import cn.easybuy.service.user.UserServiceImpl;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/Login"}, name = "Login")
public class LoginServlet extends AbstractServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService = new UserServiceImpl();

    public LoginServlet() {
        super();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class getServletClass() {
        return LoginServlet.class;
    }

    /**
     * 页面跳转
     */

    public String toLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return "/pre/login";
    }

    /**
     * 实现登录
     */
    public ReturnResult login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReturnResult result = new ReturnResult();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("username")) {
                    //如果cookie与保存的相等，即找到cookie
                    result.returnSuccess("登录成功");
                    break;
                }
            }
        }
        User user = userService.login(username, password);

        String ckValue=request.getParameter("ck");
       // System.out.print(ckValue+"------");
        if (EmptyUtils.isEmpty(user)) {
            result.returnFail("用户不存在!");

        } else {
            if (request.getParameter("ck") != null) {//如果勾选了保存密码
                response.getWriter().append(request.getParameter("save"));
                Cookie cookie = new Cookie("username", username);
                cookie.setPath("/");//保证cookie存放的根目录相同
                //设置cookie存活时间为1天
                cookie.setMaxAge(60 * 60 * 24);
                //将cookie保存在客户端
                response.addCookie(cookie);
            } else {//如果没有勾选保存密码
                Cookie cookie = new Cookie("name", username);
                cookie.setPath("/");//保证cookie存放的根目录相同
                //设置cookie存活时间为19s
                cookie.setMaxAge(19);
                //将cookie保存在客户端
                response.addCookie(cookie);
            }
            request.getSession().setAttribute("loginUser", user);
            result.returnSuccess("登录成功");
        }
        return result;
    }

    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReturnResult result = new ReturnResult();
        try {
            User user = (User) request.getSession().getAttribute("loginUser");
            request.getSession().removeAttribute("loginUser");

        } catch (Exception e) {
            e.printStackTrace();
        }
        result.returnSuccess("注销成功");
        return "/pre/index";
    }
}
