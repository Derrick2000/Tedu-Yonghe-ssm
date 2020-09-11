package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.dao.OrderMapper;
import com.tedu.pojo.Door;
import com.tedu.pojo.Order;

@Controller
public class OrderController {
	
	@Autowired
	DoorMapper doorMapper; //获取DoorMapper接口的子类实例
	@Autowired
	OrderMapper orderMapper; //获取OrderMapper接口的子类实例
	
	/** 1、查询所有订单信息 */
	@RequestMapping("/orderList")
	public String orderList(Model model) {
		//查询所有订单信息, 将查询到的订单集合存入Model中
		List<Order> list = orderMapper.findAll();
		model.addAttribute( "list", list );
		
		//查询所有门店信息, 将所有门店信息集合存入Model
		List<Door> dList = doorMapper.findAll();
		model.addAttribute( "dList", dList );
		
		//跳转到订单列表页面,显示所有订单信息
		return "order_list";
	}
	/** 2、根据id删除订单信息 */
	@RequestMapping("/orderDelete")
	public String orderDelete( Integer id ) {
		orderMapper.deleteById( id );
		//删除完后跳转到查询所有订单的方法, 显示最新的订单信息
		return "forward:/orderList";
	}
	/** 3、负责查询所有门店信息，并带到新增订单页面 */
	@RequestMapping("/toOrderAdd")
	public String toOrderAdd( Model model ) {
		//查询所有门店信息, 将所有门店信息集合存入Model
		List<Door> dList = doorMapper.findAll();
		model.addAttribute( "dList", dList );
		
		//跳转到订单新增页面(order_add.jsp)
		return "order_add";
	}
	
	/** 3、新增订单信息 */
	@RequestMapping("/orderAdd")
	public String orderAdd( Order order ) {
		//调用orderMapper的add方法, 新增订单信息
		orderMapper.add( order );
		//添加完后跳转到查询所有订单的方法, 显示最新的订单信息
		return "forward:/orderList";
	}
	/** 4、根据id查询订单信息 */
	@RequestMapping("/orderInfo")
	public String orderInfo( Integer id, Model model ) {
		//根据id查询订单信息,将订单信息存入Model中
		Order order = orderMapper.findById( id );
		model.addAttribute( "order", order );
		
		//查询所有门店信息, 将所有门店信息集合存入Model
		List<Door> dList = doorMapper.findAll();
		model.addAttribute( "dList", dList );
		
		//将订单信息带到订单修改页面, 进行数据的回显
		return "order_update";
	}
	/** 5、根据id修改订单信息 */
	@RequestMapping("/orderUpdate")
	public String orderUpdate( Order order ) { //order是用于接收修改后的订单信息
		//调用OrderMapper的updateById方法, 根据id修改订单信息
		orderMapper.updateById( order );
		//添加完后跳转到查询所有订单的方法, 显示最新的订单信息
		return "forward:/orderList";
	}
	
	
	
	

}
