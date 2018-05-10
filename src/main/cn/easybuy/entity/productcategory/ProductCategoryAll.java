package cn.easybuy.entity.productcategory;

import cn.easybuy.entity.ProductCategory;

import java.util.List;

public class ProductCategoryAll {
    public ProductCategory productCategory;  //一级
    public List<ProductCategorySecond> productCategorySecondList;


    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<ProductCategorySecond> getProductCategorySecondList() {
        return productCategorySecondList;
    }

    public void setProductCategorySecondList(List<ProductCategorySecond> productCategorySecondList) {
        this.productCategorySecondList = productCategorySecondList;
    }
}
