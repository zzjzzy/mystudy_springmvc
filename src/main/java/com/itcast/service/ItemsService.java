package com.itcast.service;

import com.itcast.pojo.ItemsQueryVo;

import java.util.List;

import com.itcast.pojo.ItemsCustom;

public interface ItemsService {

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
	
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;
}
