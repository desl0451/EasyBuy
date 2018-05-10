package cn.easybuy.service.product;

import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.dao.product.ProductDaoImpl;
import cn.easybuy.entity.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public int AddUser(Product p) {
        return productDao.Add(p);
    }

    @Override
    public int DeleteUser(Product p) {
        return productDao.Delete(p);
    }

    @Override
    public int UpdateUser(Product p) {
        return productDao.Update(p);
    }

    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    @Override
    public List<Product> getTop10Product() {
        return productDao.getTop10Product();
    }
}
