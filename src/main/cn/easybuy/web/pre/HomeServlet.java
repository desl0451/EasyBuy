package cn.easybuy.web.pre;

import cn.easybuy.entity.News;
import cn.easybuy.entity.Product;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.entity.productcategory.ProductCategoryAll;
import cn.easybuy.entity.productcategory.ProductCategorySecond;
import cn.easybuy.service.news.NewsService;
import cn.easybuy.service.news.NewsServiceImpl;
import cn.easybuy.service.product.ProductCategoryService;
import cn.easybuy.service.product.ProductCategoryServiceImpl;
import cn.easybuy.service.product.ProductService;
import cn.easybuy.service.product.ProductServiceImpl;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/Home"}, name = "Home")
public class HomeServlet extends AbstractServlet {
    private static final long serialVersionUID = 1L;

    private NewsService newsService = new NewsServiceImpl();
    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
    private ProductService productService=new ProductServiceImpl();

    public HomeServlet() {
        super();
    }

    @Override
    public Class getServletClass() {
        return HomeServlet.class;
    }

    public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<News> newsTopFive = newsService.findTop5();//显示前5条数据
        //显示前10个库存较多的产品显示在搜索栏下面
        List<Product> productTop10=productService.getTop10Product();

        //定义一级菜单和二级菜单(三级菜单)
        List<ProductCategoryAll> pcall = new ArrayList<ProductCategoryAll>();

        //返回一级菜单集合
        List<ProductCategory> productCategoryList = productCategoryService.findallProductCategoryLevel(1);//获得全部产品分类

        for (ProductCategory first : productCategoryList) {
            ProductCategoryAll all = new ProductCategoryAll();
            all.setProductCategory(first);
            //返回二级菜单集合
            List<ProductCategory> secondCategoryList = productCategoryService.findSecondCategoryLevel(new Integer(2), first.getId());
            List<ProductCategorySecond> secondList = new ArrayList<ProductCategorySecond>();
            for (ProductCategory second : secondCategoryList) {
                ProductCategorySecond s = new ProductCategorySecond();
                s.setProductCategory(second);
                //返回三级菜单集合
                List<ProductCategory> threeCategoryList = productCategoryService.findSecondCategoryLevel(new Integer(3), second.getId());
                s.setProductCategoryList(threeCategoryList);
                secondList.add(s);
            }
            all.setProductCategorySecondList(secondList);
            pcall.add(all);
        }
        request.getSession().setAttribute("productTop10",productTop10);
        request.getSession().setAttribute("productCategory", pcall);
        request.getSession().setAttribute("news", newsTopFive);
        return "/pre/index";
    }
}
