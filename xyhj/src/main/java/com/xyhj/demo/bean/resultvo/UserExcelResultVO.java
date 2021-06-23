package com.xyhj.demo.bean.resultvo;

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
public class UserExcelResultVO implements Serializable {
	
	@ApiModelProperty("姓名")
	@Excel(name = "姓名", orderNum = "0")
	private String name;
	
	@ApiModelProperty("年龄")
	@Excel(name = "年龄", orderNum = "1")
	private String age;
	
	@Excel(name = "错误信息", orderNum = "2")
	private String errorMsg;
	
}
