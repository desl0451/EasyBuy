package cn.easybuy.web.pre;

import cn.easybuy.web.AbstractServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ProductList"}, name = "ProductList")
public class ProductListServlet extends AbstractServlet {
    @Override
    public Class getServletClass() {
        return ProductListServlet.class;
    }


    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "/pre/brandlist";
    }
}
