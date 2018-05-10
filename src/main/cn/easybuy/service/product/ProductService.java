package cn.easybuy.service.product;

import cn.easybuy.entity.Product;

import java.util.List;

public interface ProductService {
    public int AddUser(Product p);

    public int DeleteUser(Product p);

    public int UpdateUser(Product p);

    public List<Product> getAllProduct();

    /**
     * 返回库存较多的产品
     * @return
     */
    public List<Product> getTop10Product();
}
