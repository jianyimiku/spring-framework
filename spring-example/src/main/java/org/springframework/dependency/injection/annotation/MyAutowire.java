package org.springframework.dependency.injection.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：sjq
 * @date ：Created in 2022/12/16 16:35
 * @description：
 * @modified By：
 * @version: $
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Autowired //使用元注解进行扩展
public @interface MyAutowire {
	boolean required() default true;
}
