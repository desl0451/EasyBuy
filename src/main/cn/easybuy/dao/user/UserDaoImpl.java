package cn.easybuy.dao.user;

import cn.easybuy.entity.User;
import cn.easybuy.utils.BaseDao;
import cn.easybuy.utils.Pager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    public User tableToClass(ResultSet rs) throws Exception {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("Email"));
        user.setIdentityCode(rs.getString("identityCode"));
        user.setLoginName(rs.getString("loginName"));
        user.setMobile(rs.getString("mobile"));
        user.setPassword(rs.getString("password"));
        user.setSex(rs.getInt("sex"));
        user.setType(rs.getInt("type"));
        user.setUserName(rs.getString("userName"));
        return user;
    }

    @Override
    public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement("select * from easybuy_User");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = tableToClass(rs);
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return userList;
    }

    @Override
    public int AddUser(User user) {
        String sql = "INSERT INTO easybuy.easybuy_user (loginName, userName, PASSWORD, sex, identityCode, email, mobile, TYPE)VALUES( ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] param = {user.getLoginName(), user.getUserName(), user.getPassword(), user.getSex(),
                user.getIdentityCode(), user.getEmail(), user.getMobile(), user.getType()};
        return this.executeUpdate(sql, param);
    }

    @Override
    public int DeleteUser(User user) {
        String sql = "DELETE FROM easybuy.easybuy_user WHERE id = ?";
        Object[] param = {user.getId()};
        return this.executeUpdate(sql, param);
    }

    @Override
    public int UpdateUser(User user) {
        String sql = "UPDATE easybuy.easybuy_user SET loginName =? , userName =? , PASSWORD = ? , sex = ? , identityCode = ? , email = ? , mobile = ? , TYPE = ? WHERE id = ?";
        Object[] param = {user.getLoginName(), user.getUserName(), user.getPassword(), user.getSex(),
                user.getIdentityCode(), user.getEmail(), user.getMobile(), user.getType(), user.getId()};
        return this.executeUpdate(sql, param);
    }

    @Override
    public User login(String username, String password) {
        String sql = "select * from easybuy_user where loginName=? and password=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, username);
            pstmt.setObject(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = tableToClass(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return user;
    }

    @Override
    public List<User> queryUserList(User user, Pager pager) {
        String sql = "select * from easybuy_user where 1=1 ";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();
        if(pager!=null){
            sql=sql+" limit "+(pager.getPageSize()*(pager.getCurrentPage()-1))+","+pager.getPageSize();
        }
        System.out.println("UserDaoImpl ====== queryUserList=="+sql+"====");
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User u = tableToClass(rs);
                userList.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return userList;
    }

    @Override
    public int count() {
        String sql = "select count(1) from easybuy_user";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int num = 0;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return num;
    }

    @Override
    public User findUserName(String username) {
        String sql = "select * from easybuy_user where loginName=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, username);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = tableToClass(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return user;
    }

}
