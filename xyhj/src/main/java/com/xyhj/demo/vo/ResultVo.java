package com.xyhj.demo.vo;

import java.util.List;

public class ResultVo {
	
	private String fieldName;
	private List<ResultVo> list;
	
	public String getFieldName() {
		return fieldName;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public List<ResultVo> getList() {
		return list;
	}
	
	public void setList(List<ResultVo> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "ResultVo{" +
				"fieldName='" + fieldName + '\'' +
				", list=" + list +
				'}';
	}
}
