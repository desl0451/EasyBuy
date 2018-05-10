package cn.easybuy.service.product;

import cn.easybuy.dao.product.ProductCategoryDao;
import cn.easybuy.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    public int Add(ProductCategory p);

    public int Delete(ProductCategory p);

    public int Update(ProductCategory p);

    public List<ProductCategory> getAllProductCategory(Integer currentPageNo,Integer pageSize,Integer level);

    /**
     * 一级目录查询
     * @param level
     * @return
     */
    public List<ProductCategory> findallProductCategoryLevel(Integer level);

    /**
     * 二级目录查询
     * @param level
     * @param parentId
     * @return
     */
    public List<ProductCategory> findSecondCategoryLevel(Integer level,Integer parentId);

    /**
     * 三级目录查询
     * @param level
     * @param parentId
     * @return
     */
    public List<ProductCategory> findThreeCategoryLevel(Integer level,Integer parentId);
}
