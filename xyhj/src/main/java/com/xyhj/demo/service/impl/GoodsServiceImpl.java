package com.xyhj.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyhj.demo.bean.Goods;
import com.xyhj.demo.bean.User;
import com.xyhj.demo.mapper.GoodsMapper;
import com.xyhj.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 12623
 */
@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	GoodsMapper goodsMapper;
	
	@Override
	public PageInfo<Goods> getPage1(int pageNum, int pageSize, String name, String categoryName) {
		PageHelper.startPage(pageNum,pageSize);
		List<Goods> goodsList = goodsMapper.getlist(name);
		List<Goods> goodsList1 = goodsMapper.getgoods(categoryName);
//		goodsList1.forEach(goods -> goodsList.add(goods));
		PageInfo<Goods> pageInfo = new PageInfo<>(goodsList1);
		System.out.println("pageInfo = " + pageInfo);
		System.out.println("getlist = " + goodsList);
		return pageInfo;
	}
	
	@Override
	public IPage<Goods> getPage(int pageNum, int pageSize, String name) {
		Page<Goods> page = new Page<>(pageNum,pageSize);
		IPage<Goods> iPage = goodsMapper.getPage(page, name);
		System.out.println("name = " + name);
		System.out.println("List = " + iPage.getRecords().toString());
		return iPage;
	}
	
	@Override
	public List<Goods> selectList() {
		
		
		return null;
	}
}
