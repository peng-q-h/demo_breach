package com.xyhj.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 12623
 */
@Data
public class Goods implements Serializable {
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
}
