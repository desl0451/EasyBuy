package cn.easybuy.dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.entity.Order;
import cn.easybuy.utils.BaseDao;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM easybuy.easybuy_order WHERE id = ?";
		Object[] param = { id };
		this.executeUpdate(sql, param);
	}

	@Override
	public void add(Order order) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO easybuy.easybuy_order(userId, loginName, userAddress, createTime, cost, serialNumber)VALUES(?,?,?,?,?,?)";
		Object[] param = { order.getUserId(), order.getLoginName(), order.getUserAddress(), order.getCreateTime(),
				order.getCost(), order.getSerialNumber() };
		this.executeUpdate(sql, param);
	}

	@Override
	public Order getOrderById(Integer id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order order = null;
		try {
			conn = this.getConn();
			pstmt = conn.prepareStatement("SELECT * FROM 	easybuy_order  WHERE id=?");
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();
			order = tableToClass(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return order;
	}

	@Override
	public List<Order> getOrderList(Integer userId, Integer currentPageNo, Integer pageSize) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Order> orderList = new ArrayList<Order>();
		try {
			conn = this.getConn();
			pstmt = conn.prepareStatement("SELECT * FROM 	easybuy_order");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order = tableToClass(rs);
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return orderList;
	}

	@Override
	public Integer count(Integer userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = this.getConn();
			pstmt = conn.prepareStatement("SELECT count(1) as id FROM easybuy_order");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return count;
	}

	public Order tableToClass(ResultSet rs) throws Exception {
		Order order = new Order();
		order.setCost(rs.getFloat("cost"));
		order.setCreateTime(rs.getDate("createTime"));
		order.setId(rs.getInt("id"));
		order.setLoginName(rs.getString("loginName"));
		order.setSerialNumber(rs.getString("serialNumber"));
		order.setUserAddress(rs.getString("userAddress"));
		order.setUserId(rs.getInt("userId"));
		return order;
	}
}
