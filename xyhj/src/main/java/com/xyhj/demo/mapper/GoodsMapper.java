package com.xyhj.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xyhj.demo.bean.Goods;
import com.xyhj.demo.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author 12623
 */

public interface GoodsMapper extends BaseMapper<Goods> {
	
	IPage<Goods> getPage(IPage<Goods> page, @Param("name") String name);
	
	List<Goods> getlist(String name);
	
	
	List<Goods> getgoods(String categoryName);
}
