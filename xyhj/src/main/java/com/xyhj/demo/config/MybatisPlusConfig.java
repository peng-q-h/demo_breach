package com.xyhj.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

@Configuration
@MapperScan("com.xyhj.demo.mapper")
public class MybatisPlusConfig {

	@Bean
	public PaginationInterceptor paginationInterceptor(){
		return new PaginationInterceptor();
	}
	
	@Bean
	public PageHelper pageHelper() {
		return new PageHelper();
	}
	
	
}
