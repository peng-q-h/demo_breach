package com.xyhj.demo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(description = "用户实体类")
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {
	@ApiModelProperty("用户id")
	private long id;
	@ApiModelProperty("用户姓名")
	private String name;
	@ApiModelProperty("用户年龄")
	private String age;
}
