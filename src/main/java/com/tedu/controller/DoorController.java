package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

/* @Controller: (1)表示当前类属于controller层
 * 	标识当前类的对象的创建由spring容器负责
 */
@Controller
public class DoorController {
	
	/* 在spring的配置文件中配置过dao包扫描, 在程序执行时, 框架底层
	 * 	会扫描dao包下的所有mapper接口, 为接口提供子类, 并根据子类
	 * 	创建实例——即接口的子类实例, @Autowired可以根据接口的类型
	 *	到spring容器中获取接口的子类实例, 并赋值给dao!
	 */
	@Autowired
	private DoorMapper dao;
	
	/** 1、查询所有的门店信息 */
	@RequestMapping("/doorList")
	public String doorList( Model model ) {
		//调用DoorMapper的findAll方法查询所有门店信息
		List<Door> list = dao.findAll();
		//将门店集合存入到Model中
		model.addAttribute( "list" , list );
		//跳转到门店列表(door_list.jsp)页面(在该页面中展示所有门店信息)
		return "door_list"; 
	}
	
	/** 2、根据id删除门店信息 */
	@RequestMapping("/doorDelete")
	public String doorDelete(Integer id) {
		//调用DoorMapper的deleteById方法, 根据id删除门店信息
		dao.deleteById( id );
		//删除成功后,跳转到查询门店的方法, 显示最新门店信息
		return "forward:/doorList"; 
	}
	
	/** 3、新增门店信息
	 * 接收客户端提交过来的门店信息(name,tel,addr)
	 */
	@RequestMapping("/doorAdd")
	public String doorAdd( Door door ) {
		//调用DoorMapper的add方法, 新增门店信息
		dao.add( door );
		//跳转到查询所有门店的方法, 显示最新门店信息
		return "forward:/doorList";
	}
	
	/** 4、根据id查询门店信息
	 * 将查询到的门店信息带到门店修改页面, 进行数据的回显
	 */
	@RequestMapping("/doorInfo")
	public String doorInfo(Integer id, Model model) {
		//调用DoorMapper的findById方法, 根据id查询门店信息
		Door door = dao.findById( id );
		//将门店信息带回门店修改页面, 进行回显
		model.addAttribute( "door", door );
		//转发到门店修改页面
		return "door_update";
	}
	
	/** 5、根据id修改门店信息 */
	@RequestMapping("/doorUpdate")
	public String doorUpdate( Door door ) {
		//调用DoorMapper的updateById方法, 根据id修改门店信息
		dao.updateById( door );
		
		//跳转到查询所有门店的方法, 显示最新门店信息
		return "forward:/doorList";
	}
	
	/* 	声明一个通用的页面跳转方法: 通过访问jsp的名字
	 * 	可以跳转到/WEB-INF/pages/下面指定名字的jsp页面
	 * 	其中{}中的 jspName 用于接收访问的路径名, 例如: 
	 * 		访问地址为: localhost/项目名称/index
	 * 		此时, jspName的值就是 index
	 * 	再将{}中jspName的值传递给方法上的形参jspName,值也为index
	 * 	最后再将jspName作为返回值返回, 也就是跳转到指定名称的jsp
	 */
	@RequestMapping("/{jspName}")
	public String toJsp(@PathVariable String jspName) {
		return jspName; //可以跳转到任何的jsp
	}
	
	
	//================================
	/* 测试2: 测试ssm的运行环境 */
	@RequestMapping("/testssm")
	public String testssm() {
		System.out.println("DoorController.testssm()");
		//查询所有的门店信息
		List<Door> list = dao.findAll();
		for (Door door : list) {
			System.out.println( door );
		}
		return "test";
	}
	
	
	/* 测试1: 测试springmvc的运行环境 */
	@RequestMapping("/testmvc")
	public String testmvc() {
		System.out.println("DoorController.testmvc()...");
		return "test";
	}
	
}




