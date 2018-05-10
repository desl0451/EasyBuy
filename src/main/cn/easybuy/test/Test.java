package cn.easybuy.test;

import cn.easybuy.dao.news.NewsDaoImpl;

public class Test {

    public static void main(String args[]) {
//        NewsService newsService = new NewsServiceImpl();
//        ProductCategoryService productService = new ProductCategoryServiceImpl();
//        //定义一级菜单和二级菜单
//        List<ProductCategoryAll> pcall = new ArrayList<ProductCategoryAll>();
//
//        //返回一级菜单集合
//        List<ProductCategory> productCategoryList = productService.findallProductCategoryLevel(1);//获得全部产品分类
//
//        //返回二级菜单集合
//        List<ProductCategory> secondCategoryList = null;
//
//        for (ProductCategory pca : productCategoryList) {
//            ProductCategoryAll all = new ProductCategoryAll();
//            all.setProductFirst(pca);
//            secondCategoryList = productService.findSecondCategoryLevel(new Integer(2), pca.getId());
//            all.setProductSecond(secondCategoryList);
//            pcall.add(all);
//        }
//
//        for (ProductCategoryAll all : pcall) {
//            System.out.println(all.getProductFirst().getName());
//
//            for(ProductCategory p:all.getProductSecond()){
//                System.out.print(p.getName()+"\t");
//            }
//
//            System.out.println("\n");
//        }

        NewsDaoImpl dao=new NewsDaoImpl();
        int i=dao.queryNewsCount();
        System.out.println(i);
    }
}
