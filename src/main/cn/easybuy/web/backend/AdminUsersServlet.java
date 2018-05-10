package cn.easybuy.web.backend;

import cn.easybuy.entity.User;
import cn.easybuy.service.user.UserService;
import cn.easybuy.service.user.UserServiceImpl;
import cn.easybuy.utils.Pager;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/User"}, name = "User")
public class AdminUsersServlet extends AbstractServlet {

    private UserService userService=new UserServiceImpl();

    public String toFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo=request.getParameter("currentPage");
        int currentPage=0;
        if(pageNo!=null){
            currentPage=Integer.parseInt(pageNo);
        }else{
            currentPage=1;
        }
        int pageSize=7;
        int titleCount=userService.count();//总用户数
        Pager pager=new Pager(currentPage,pageSize,titleCount);
        pager.setUrl("User?action=toFind");
        User user=new User();
        List<User> userList=userService.queryUserList(user,pager);
        request.getSession().setAttribute("userList",userList);
        request.getSession().setAttribute("pager",pager);
        return "/backend/user/userlist";
    }

    @Override
    public Class getServletClass() {
        return AdminUsersServlet.class;
    }
}
