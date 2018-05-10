package cn.easybuy.dao.order;

import java.util.List;

import cn.easybuy.entity.OrderDetail;

public interface OrderDetailDao {
	public void add(OrderDetail detail) throws Exception;

	public void deleteById(OrderDetail detail) throws Exception;

	public OrderDetail getOrderDetailById(Integer id) throws Exception;

	public List<OrderDetail> getOrderDetailList(Integer orderId) throws Exception;

	public Integer queryOrderDetailCount(OrderDetail params) throws Exception;
}
