package com.xyhj.demo.annotation;

import java.lang.annotation.*;

/**
 * @author 12623
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PassAspect {
	String value() default "";
}
