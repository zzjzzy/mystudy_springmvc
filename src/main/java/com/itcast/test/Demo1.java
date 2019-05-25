package com.itcast.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itcast.mapper.ItemsMapperCustom;
import com.itcast.mapper.UserMapper;
import com.itcast.pojo.ItemsCustom;
import com.itcast.pojo.ItemsQueryVo;
import com.itcast.pojo.User;
import com.itcast.service.ItemsService;
import com.itcast.service.impl.ItemsServiceImpl;

public class Demo1 {
	
	ApplicationContext app;
	
	@Before
	public void beforeFun() {
		app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}
	
	@Test
	public void fun1() {
		UserMapper userMapper = (UserMapper) app.getBean("userMapper");
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user);
	}
	
	@Test
	public void fun2() throws Exception {
		ItemsMapperCustom itemsMapperCustom = (ItemsMapperCustom) app.getBean("itemsMapperCustom");
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setName("笔记本");
		ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
		itemsQueryVo.setItemsCustom(itemsCustom);
		List<ItemsCustom> itemsList = itemsMapperCustom.findItemsList(itemsQueryVo);
		System.out.println(itemsList);
	}
	
	@Test
	public void fun3() throws Exception {
		ItemsService itemsService = (ItemsService) app.getBean("itemsService");
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setName("笔记本");
		ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
		itemsQueryVo.setItemsCustom(itemsCustom);
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		System.out.println(itemsList);
	}

}
