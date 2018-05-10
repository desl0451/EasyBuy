package cn.easybuy.dao.product;

import cn.easybuy.entity.ProductCategory;
import cn.easybuy.utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoImpl extends BaseDao implements ProductCategoryDao {

    public ProductCategory tabltToCalss(ResultSet rs) throws Exception {
        ProductCategory productcate = new ProductCategory();
        productcate.setIconClass(rs.getString("iconClass"));
        productcate.setId(rs.getInt("id"));
        productcate.setName(rs.getString("name"));
        productcate.setParentId(rs.getInt("parentid"));
//        productcate.setParentName(rs.getString("parentName"));
        productcate.setType(rs.getInt("type"));
        return productcate;
    }

    @Override
    public int Add(ProductCategory p) {
        String sql = "";
        Object[] param = {};
        return this.executeUpdate(sql, param);
    }

    @Override
    public int Delete(ProductCategory p) {
        String sql = "";
        Object[] param = {p.getId()};
        return this.executeUpdate(sql, param);
    }

    @Override
    public int Update(ProductCategory p) {
        String sql = "";
        Object[] param = {};
        return this.executeUpdate(sql, param);
    }

    @Override
    public List<ProductCategory> findSecondCategoryLevel(Integer level, Integer parentId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ProductCategory> productList = new ArrayList<ProductCategory>();
        StringBuffer sql = new StringBuffer("select * from easybuy_product_category where 1=1 ");
        try {
            conn = this.getConn();
            if (level != null) {
                sql.append(" and type="+level);
            }
            if(parentId!=null){
                sql.append(" and parentId="+parentId);
            }
            //System.out.println(sql.toString()+"==============");
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductCategory product = tabltToCalss(rs);
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
    public List<ProductCategory> findThreeCategoryLevel(Integer level, Integer parentId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ProductCategory> productList = new ArrayList<ProductCategory>();
        StringBuffer sql = new StringBuffer("select * from easybuy_product_category where 1=1 ");
        try {
            conn = this.getConn();
            if (level != null) {
                sql.append(" and type="+level);
            }
            if(parentId!=null){
                sql.append(" and parentId="+parentId);
            }
            //System.out.println(sql.toString()+"==============");
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductCategory product = tabltToCalss(rs);
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
    public List<ProductCategory> findallProductCategoryLevel(Integer level) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ProductCategory> productList = new ArrayList<ProductCategory>();
        StringBuffer sql = new StringBuffer("select * from easybuy_product_category where 1=1 ");
        try {
            conn = this.getConn();
            if (level != null) {
                sql.append(" and type="+level);
            }
            //System.out.println(sql.toString()+"==============");
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductCategory product = tabltToCalss(rs);
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
    public List<ProductCategory> getAllProductCategory(Integer currentPageNo, Integer pageSize, Integer level) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ProductCategory> productList = new ArrayList<ProductCategory>();
        StringBuffer sql = new StringBuffer("select * from easybuy_product_category where 1=1 ");
        try {
            conn = this.getConn();
            if (level != null) {
                sql.append(" and type="+level);
            }
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductCategory product = tabltToCalss(rs);
                productList.add(product);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return productList;
    }
}
