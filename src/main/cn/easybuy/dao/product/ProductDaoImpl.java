package cn.easybuy.dao.product;

import cn.easybuy.entity.Product;
import cn.easybuy.utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseDao implements ProductDao {
    public Product tabltToCalss(ResultSet rs) throws Exception {
        Product product = new Product();
        product.setCategoryLevel1Id(rs.getInt("CategoryLevel1Id"));
        product.setCategoryLevel2Id(rs.getInt("CategoryLevel2Id"));
        product.setCategoryLevel3Id(rs.getInt("CategoryLevel3Id"));
        product.setDescription(rs.getString("Description"));
        product.setFileName(rs.getString("FileName"));
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getFloat("Price"));
        product.setStock(rs.getInt("Stock"));
        return product;
    }

    @Override
    public int Add(Product p) {
        String sql = "";
        Object[] param = {};
        return this.executeUpdate(sql, param);
    }

    @Override
    public int Update(Product p) {
        String sql = "";
        Object[] param = {};
        return this.executeUpdate(sql, param);
    }

    @Override
    public List<Product> getAllProduct() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<Product>();
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement("select * from easybuy_product");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = tabltToCalss(rs);
                productList.add(product);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return productList;
    }

    /**
     * 分页显示产品
     *
     * @param currentPageNo
     * @param pageSize
     * @param categoryId
     * @return
     */
    @Override
    public List<Product> getProductPage(Integer currentPageNo, Integer pageSize, Integer categoryId,Integer level) {
        String sql = "select * from easybuy_product where 1=1 ";
        List<Product> productList = new ArrayList<Product>();
        try {
            if (categoryId != null) {
                sql = sql + " and categoryLevel1Id=" + categoryId;
            }
            sql=sql+" limit "+(currentPageNo*pageSize-1)+","+pageSize;
            System.out.print(sql+"======");
        } catch (Exception ex) {

        }
        return productList;
    }

    @Override
    public List<Product> getTop10Product() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<Product>();
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement("select * from easybuy_product order by stock limit 8");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = tabltToCalss(rs);
                productList.add(product);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return productList;
    }

    @Override
    public int Delete(Product p) {
        String sql = "";
        Object[] param = {};
        return this.executeUpdate(sql, param);
    }
}
