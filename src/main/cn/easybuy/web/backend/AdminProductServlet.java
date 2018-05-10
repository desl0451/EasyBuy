package cn.easybuy.web.backend;

import cn.easybuy.entity.ProductCategory;
import cn.easybuy.service.product.ProductCategoryService;
import cn.easybuy.service.product.ProductCategoryServiceImpl;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = {"/Product"}, name = "Product")
public class AdminProductServlet extends AbstractServlet {
    ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();

    public String toAddProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<ProductCategory> productCategoryList1 = productCategoryService.findallProductCategoryLevel(1);



        request.getSession().setAttribute("productCategoryList1",productCategoryList1);
        return "backend/product/toAddProduct";
    }

    @Override
    public Class getServletClass() {
        return AdminProductServlet.class;
    }
}
