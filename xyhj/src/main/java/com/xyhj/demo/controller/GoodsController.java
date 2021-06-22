package com.xyhj.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.xyhj.demo.bean.Goods;
import com.xyhj.demo.service.GoodsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author 12623
 */
//@RestController
//@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	GoodsService goodsService;
	
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNum", value = "", required = true, dataType = "int", paramType = "path"),
			@ApiImplicitParam(name = "pageSize", value = "", required = true, dataType = "int", paramType = "path"),
			@ApiImplicitParam(name = "name", value = "", required = false, dataType = "String", paramType = "path")
	})
	@GetMapping("/page/{pageNum}/{pageSize}/{name}")
	public IPage<Goods> getPage(@PathVariable("pageNum") int pageNum,
								@PathVariable("pageSize") int pageSize,
								@PathVariable String name) {
		System.out.println("name = " + name);
		return goodsService.getPage(pageNum, pageSize, name);
	}
	
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNum", value = "", required = true, dataType = "int", paramType = "path"),
			@ApiImplicitParam(name = "pageSize", value = "", required = true, dataType = "int", paramType = "path"),
			@ApiImplicitParam(name = "name", value = "", required = false, dataType = "String", paramType = "path")
	})
	@GetMapping("/page1/{pageNum}/{pageSize}/{name}/{categoryName}")
	public PageInfo<Goods> getPage1(@PathVariable("pageNum") int pageNum,
									@PathVariable("pageSize") int pageSize,
									@PathVariable("name") String name,
									@PathVariable("categoryName") String categoryName) {
		System.out.println("name = " + name);
		return goodsService.getPage1(pageNum, pageSize, name, categoryName);
	}
	
	
	
}
