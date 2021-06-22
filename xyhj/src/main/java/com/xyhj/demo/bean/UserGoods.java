package com.xyhj.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserGoods {
	private Double id;
	private int userId;
	private String title;
	private BigDecimal price;
	private Double stock;
	private Double saleNum;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date createTime;
	private String categoryName;
	private String brandName;
	private String spec;
	@ApiModelProperty("用户姓名")
	private String name;
	@ApiModelProperty("用户年龄")
	private String age;
}
