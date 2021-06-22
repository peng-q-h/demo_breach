package com.xyhj.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.xyhj.demo.bean.Goods;

import java.util.List;

/**
 * @author 12623
 */
public interface GoodsService {
	/**
	 *
	 * @param pageNum 当前页
	 * @param pageSize 每页条数
	 * @param name
	 * @return
	 */
	IPage<Goods> getPage(int pageNum, int pageSize, String name);
	
	PageInfo<Goods> getPage1(int pageNum, int pageSize, String name, String categoryName);
	
	List<Goods> selectList();
	
}
