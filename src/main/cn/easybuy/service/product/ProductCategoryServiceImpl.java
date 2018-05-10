package cn.easybuy.service.product;

import cn.easybuy.dao.product.ProductCategoryDao;
import cn.easybuy.dao.product.ProductCategoryDaoImpl;
import cn.easybuy.entity.ProductCategory;

import java.util.List;

public class ProductCategoryServiceImpl implements ProductCategoryService {
    private ProductCategoryDao productcategory = new ProductCategoryDaoImpl();

    @Override
    public int Add(ProductCategory p) {
        return this.productcategory.Add(p);
    }

    @Override
    public List<ProductCategory> findThreeCategoryLevel(Integer level, Integer parentId) {
        return this.productcategory.findThreeCategoryLevel(level, parentId);
    }

    @Override
    public List<ProductCategory> findallProductCategoryLevel(Integer level) {
        return this.productcategory.findallProductCategoryLevel(level);
    }

    @Override
    public List<ProductCategory> findSecondCategoryLevel(Integer level, Integer parentId) {
        return this.productcategory.findSecondCategoryLevel(level, parentId);
    }

    @Override
    public int Delete(ProductCategory p) {
        return this.productcategory.Delete(p);
    }

    @Override
    public int Update(ProductCategory p) {
        return this.productcategory.Update(p);
    }

    @Override
    public List<ProductCategory> getAllProductCategory(Integer currentPageNo, Integer pageSize, Integer level) {
        return this.productcategory.getAllProductCategory(currentPageNo, pageSize, level);
    }
}
