package cn.easybuy.dao.order;

import java.util.List;

import cn.easybuy.entity.Order;

public interface OrderDao {
	public void add(Order order);

	public void deleteById(Integer id);

	public Order getOrderById(Integer id);

	public List<Order> getOrderList(Integer userId, Integer currentPageNo, Integer pageSize);

	public Integer count(Integer userId);
}
