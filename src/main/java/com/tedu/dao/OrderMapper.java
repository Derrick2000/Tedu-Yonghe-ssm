package com.tedu.dao;

import java.util.List;
import com.tedu.pojo.Order;

/**
 * 订单模块的Dao接口
 */
public interface OrderMapper {
	
	/** 1、查询所有的订单信息 */
	public List<Order> findAll();
	
	/** 2、根据id删除订单信息 */
	public void deleteById(Integer id);
	
	/** 3、新增订单信息 */
	public void add(Order order);
	
	/** 4、根据id查询订单信息 */
	public Order findById(Integer id);
	
	/** 5、根据id修改订单信息 */
	public void updateById(Order order);
	
	
}



