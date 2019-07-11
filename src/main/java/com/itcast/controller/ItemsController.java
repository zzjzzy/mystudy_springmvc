package com.itcast.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.itcast.pojo.ItemsCustom;
import com.itcast.service.ItemsService;

//注解方式开发Controller

@Controller
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
		public String editItemsSubmit(Model model, HttpServletRequest request,Integer id,
				@Validated ItemsCustom itemsCustom, BindingResult bindingResult,
				MultipartFile items_pic)throws Exception {
			
			if (bindingResult.hasErrors()) {
				List<ObjectError> allErrors = bindingResult.getAllErrors();
				model.addAttribute("allErrors", allErrors);
				return "items/editItems";
				
			}
			System.out.println(items_pic);
			String pic_path = "D:\\software\\apache-tomcat-8.5.41\\webapps\\springmvc\\pic\\";
			String originalFilename = null;
			if (items_pic != null) {
				originalFilename = items_pic.getOriginalFilename(); 
			}
			if (originalFilename != null && originalFilename.length() > 0) {
				String newName = UUID.randomUUID() + "_" + originalFilename;
				
				File file = new File(pic_path + newName);
				items_pic.transferTo(file);
				itemsCustom.setPic(newName);
				System.out.println("保存图片成功");
			}

			//调用service更新商品信息，页面需要将商品信息传到此方法
			itemsService.updateItems(id, itemsCustom);
			System.out.println(itemsCustom);
			
//			重定向到商品查询列表
			return "redirect:queryItems.action";
			//页面转发
			//return "forward:queryItems.action";
//			return "success";
		}
	
}
