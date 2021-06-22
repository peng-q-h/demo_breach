package com.xyhj.demo.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: pengquanhong
 * @Date: 2021/6/8 13:22
 * @Description:
 */
@Data
public class UserVO {
	@ApiModelProperty("用户id")
	private long id;
	@ApiModelProperty("用户姓名")
	private String name;
	@ApiModelProperty("用户性别")
	private String sex;
	
}
