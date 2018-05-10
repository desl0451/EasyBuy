package cn.easybuy.entity.productcategory;

import cn.easybuy.entity.ProductCategory;

import java.util.List;

public class ProductCategorySecond {
    public ProductCategory productCategory; //二级菜单
    public List<ProductCategory> productCategoryList;//三级菜单

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }
}
