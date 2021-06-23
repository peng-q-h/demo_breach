package com.xyhj.demo.bean;

import lombok.Data;

import java.util.Date;

/**
 * @Author: pengquanhong
 * @Date: 2021/6/23 14:02
 * @Description:
 */
@Data
public class Order {
	private String code;
	private Date createTime;
}
