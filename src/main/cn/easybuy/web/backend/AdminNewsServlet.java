package cn.easybuy.web.backend;

import cn.easybuy.entity.News;
import cn.easybuy.service.news.NewsService;
import cn.easybuy.service.news.NewsServiceImpl;
import cn.easybuy.utils.Pager;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/News"}, name = "News")
public class AdminNewsServlet extends AbstractServlet {
    private NewsService newsService = new NewsServiceImpl();

    public String toFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取当前页
        String no = request.getParameter("currentPage");
        Integer currentPage =null;
        if(no!=null){
            currentPage=Integer.parseInt(no);
        }else{
            currentPage=1;
        }
        //设置每页显示记数
        Integer pageSize = 10;
        //取得总记录数
        Integer titleCount = newsService.queryNewsCount();

        Pager pager = new Pager(currentPage, pageSize, titleCount);
        pager.setUrl("News?action=toFind");
        News news = new News();
        List<News> newsList = newsService.queryNewsList(news, pager);
        request.getSession().setAttribute("newsList", newsList);
        request.getSession().setAttribute("pager", pager);
        request.getSession().setAttribute("menu", 7);
        return "backend/news/newsList";
    }

    @Override
    public Class getServletClass() {
        return AdminNewsServlet.class;
    }
}
