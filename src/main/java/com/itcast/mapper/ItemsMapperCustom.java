package com.itcast.mapper;

import com.itcast.pojo.Items;
import com.itcast.pojo.ItemsCustom;
import com.itcast.pojo.ItemsExample;
import com.itcast.pojo.ItemsQueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapperCustom {
    //商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;
}