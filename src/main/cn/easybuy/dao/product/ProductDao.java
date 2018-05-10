package cn.easybuy.dao.product;

import cn.easybuy.entity.Product;

import java.util.List;

public interface ProductDao {

    public int Add(Product p);

    public int Delete(Product p);

    public int Update(Product p);

    public List<Product> getAllProduct();

    public List<Product> getProductPage(Integer currentPageNo,Integer pageSize ,Integer categoryId,Integer level);

    /**
     * 返回库存较多的产品
     * @return
     */
    public List<Product> getTop10Product();

}
