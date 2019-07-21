package com.itcast.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itcast.pojo.Items;
import com.itcast.pojo.ItemsCustom;
import com.itcast.service.ItemsService;

//注解方式开发Controller

@Controller
@RequestMapping("/study")
public class studyController{
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/json")
	@ResponseBody
	public List<Map<String, Double>> queryItems(Items items)throws Exception{
		System.out.println(items.getName());
		List<Map<String, Double>> list = new ArrayList<Map<String, Double>>(12);
//		List<Items> list = new ArrayList<Items>();
		Map<String, Double> map = null;
		for (int i=0; i<12; i++) {
			map = new HashMap<String, Double>();
			map.put((i+1)+"月#1机组煤用量", 163550.39);
			map.put((i+1)+"月#1机组煤热值", 19.6);
			map.put((i+1)+"月#2机组煤用量", 162550.8);
			map.put((i+1)+"月#2机组煤热值", 19.4);
			list.add(map);
		}
		
//		map = new HashMap<String, Double>();
//		map.put("aaa", 12.4);
//		Items item = new Items();
//		item.setName("电脑");
		return list;
	}

	
}
