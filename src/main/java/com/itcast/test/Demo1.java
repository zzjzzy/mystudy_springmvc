package com.itcast.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itcast.mapper.UserMapper;
import com.itcast.pojo.User;

public class Demo1 {
	
	@Test
	public void fun1() {
		ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
		UserMapper userMapper = (UserMapper) app.getBean("userMapper");
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user);
	}

}
