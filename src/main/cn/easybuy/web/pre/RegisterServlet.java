package cn.easybuy.web.pre;

import cn.easybuy.entity.User;
import cn.easybuy.service.news.NewsService;
import cn.easybuy.service.news.NewsServiceImpl;
import cn.easybuy.service.user.UserService;
import cn.easybuy.service.user.UserServiceImpl;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.utils.SecurityUtils;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Register", name = "Register")
public class RegisterServlet extends AbstractServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();
    private NewsService newsService = new NewsServiceImpl();

    public RegisterServlet() {
        super();
    }

    public String toRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return "/pre/regist";
    }

    public ReturnResult saveUserToDatabase(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ReturnResult result = new ReturnResult();
        try {

            User user = new User();
            String loginName = request.getParameter("loginName");
            String sex = request.getParameter("sex");
            User oldUser = userService.findUserName(loginName);
            if (EmptyUtils.isNotEmpty(oldUser)) {
                result.returnFail("用户已经存在");
                return result;
            }

            //判断用户
            user.setLoginName(request.getParameter("loginName"));
            user.setUserName(request.getParameter("userName"));
            user.setSex(EmptyUtils.isEmpty(sex) ? 1 : 0);
            user.setPassword(SecurityUtils.md5Hex(request.getParameter("password")));
            user.setIdentityCode(request.getParameter("identityCode"));
            user.setEmail(request.getParameter("email"));
            user.setMobile(request.getParameter("mobile"));
            user.setType(0);
            int i = userService.AddUser(user);
            if (i > 0) {
                result.returnSuccess("注册成功!");
            } else {
                result.returnFail("注册失败!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Class getServletClass() {
        // TODO Auto-generated method stub
        return RegisterServlet.class;
    }

}
