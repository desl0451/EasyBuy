package cn.easybuy.dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.entity.Order;
import cn.easybuy.entity.OrderDetail;
import cn.easybuy.utils.BaseDao;

public class OrderDetailDaoImpl extends BaseDao implements OrderDetailDao {

	@Override
	public void add(OrderDetail detail) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO easybuy.easybuy_order_detail(orderId, productId, quantity, cost)VALUES(?,?,?,?)";
		Object[] param = { detail.getOrderId(), detail.getProductId(), detail.getQuantity(), detail.getCost() };
		this.executeUpdate(sql, param);
	}

	@Override
	public void deleteById(OrderDetail detail) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM easybuy.easybuy_order_detail WHERE id = ?";
		Object[] param = { detail.getId() };
		this.executeUpdate(sql, param);
	}

	@Override
	public OrderDetail getOrderDetailById(Integer id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderDetail orderDetail = null;
		try {
			conn = this.getConn();
			pstmt = conn.prepareStatement("SELECT * FROM 	easybuy_order_detail  WHERE id=?");
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();
			orderDetail = tableToClass(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return orderDetail;
	}

	@Override
	public List<OrderDetail> getOrderDetailList(Integer orderId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		try {
			conn = this.getConn();
			pstmt = conn.prepareStatement("SELECT * FROM 	easybuy_order_detail");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderDetail order = tableToClass(rs);
				orderDetailList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return orderDetailList;
	}

	@Override
	public Integer queryOrderDetailCount(OrderDetail params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderDetail tableToClass(ResultSet rs) throws Exception {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCost(rs.getFloat("cost"));
		orderDetail.setId(rs.getInt("id"));
		orderDetail.setOrderId(rs.getInt("orderId"));
		orderDetail.setProductId(rs.getInt("ProductId"));
		orderDetail.setQuantity(rs.getInt("quantity"));
		return orderDetail;
	}
}
