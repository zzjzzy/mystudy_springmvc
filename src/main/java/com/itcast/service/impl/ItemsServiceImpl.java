package com.itcast.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itcast.mapper.ItemsMapper;
import com.itcast.mapper.ItemsMapperCustom;
import com.itcast.pojo.Items;
import com.itcast.pojo.ItemsCustom;
import com.itcast.pojo.ItemsQueryVo;
import com.itcast.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	//逆向工程生成的mapper
	@Autowired
	private ItemsMapper itemsMapper;

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		List<ItemsCustom> itemsList = itemsMapperCustom.findItemsList(itemsQueryVo);
		return itemsList;
	}

		public ItemsCustom findItemsById(Integer id) throws Exception {
			//逆向工程里的方法
			Items items = itemsMapper.selectByPrimaryKey(id);
			//中间对商品信息进行业务处理
			//....如判断商品日期是否过期
			//返回ItemsCustom
			ItemsCustom itemsCustom = new ItemsCustom();
			//将items的属性值拷贝到itemsCustom，spring提供的属性拷贝工具类
			BeanUtils.copyProperties(items, itemsCustom);
			
			return itemsCustom;
			
		}

		public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
			//添加业务校验，通常在service接口对关键参数进行校验
			//校验 id是否为空，如果为空抛出异常
			
			//更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括 大文本类型字段
			//updateByPrimaryKeyWithBLOBs要求必须转入id
			itemsCustom.setId(id);
			itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
		}

}
