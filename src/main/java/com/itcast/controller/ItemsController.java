package com.itcast.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import com.itcast.pojo.Items;
import com.itcast.pojo.ItemsCustom;
import com.itcast.pojo.ItemsQueryVo;
import com.itcast.service.ItemsService;

//注解方式开发Controller

@org.springframework.stereotype.Controller
@RequestMapping("/items")
public class ItemsController{
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems()throws Exception{
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		ModelAndView modelAndView =  new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
	    modelAndView.setViewName("items/itemsList");

		return modelAndView;	
	}
	
	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	public String editItems(Model model,@RequestParam(value="id",required=true) Integer items_id)throws Exception {
		
		//调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
		
		//通过形参中的model将model数据传到页面
		//相当于modelAndView.addObject方法
		model.addAttribute("itemsCustom", itemsCustom);
		
        //return也可以返回字符串，然后通过形参加上Model来设置页面填充的数据。
		return "items/editItems";
	}
	
	//商品信息修改提交
		@RequestMapping("/editItemsSubmit")
		public String editItemsSubmit(HttpServletRequest request,Integer id,ItemsCustom itemsCustom)throws Exception {
			
			//调用service更新商品信息，页面需要将商品信息传到此方法
			itemsService.updateItems(id, itemsCustom);
//			System.out.println(itemsCustom);
			
			//重定向到商品查询列表
//			return "redirect:queryItems.action";
			//页面转发
			//return "forward:queryItems.action";
			return "success";
		}
	
}
