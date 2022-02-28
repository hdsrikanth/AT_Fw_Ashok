package com.avin.networks.at.utility;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.avin.networks.at.config.enums.CategoryType;


@Retention(RUNTIME)
@Target(METHOD)
public @interface CustomAnnotation {
	
	public String[] author();
	
	public CategoryType[] category();

}
