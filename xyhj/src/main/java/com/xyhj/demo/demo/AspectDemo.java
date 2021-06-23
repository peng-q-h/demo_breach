package com.xyhj.demo.demo;

import com.xyhj.demo.annotation.PassAspect;

/**
 * @author 12623
 */
public class AspectDemo {
	
	@PassAspect("注解中的值")
	public String execution() {
		return null;
	}
}
