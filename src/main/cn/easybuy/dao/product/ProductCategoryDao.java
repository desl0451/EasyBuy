package cn.easybuy.dao.product;

import cn.easybuy.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {
    public int Add(ProductCategory p);

    public int Delete(ProductCategory p);

    public int Update(ProductCategory p);

    public List<ProductCategory> getAllProductCategory(Integer currentPageNo,Integer pageSize,Integer level);

    public List<ProductCategory> findallProductCategoryLevel(Integer level);

    public List<ProductCategory> findSecondCategoryLevel(Integer level,Integer parentId);

    public List<ProductCategory> findThreeCategoryLevel(Integer level,Integer parentId);

}
