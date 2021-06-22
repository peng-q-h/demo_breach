package com.xyhj.demo.bean.queryvo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: pengquanhong
 * @Date: 2021/6/17 10:34
 * @Description:
 */
@Data
public class UserExcelVO implements Serializable, IExcelDataModel, IExcelModel {
	
	
	/**
	 * 行号
	 */
	private Integer rowNum;
	/**
	 * 错误消息
	 */
	@Excel(name = "错误信息", orderNum = "3")
	private String errorMsg;
	
	@ApiModelProperty("姓名")
	@Excel(name = "姓名", orderNum = "0")
	@NotBlank(message = "姓名不能为空")
	private String name;
	
	@ApiModelProperty("年龄")
	@Excel(name = "年龄", orderNum = "1")
	@NotBlank(message = "年龄不能为空")
	private String age;
	
	
	
}
