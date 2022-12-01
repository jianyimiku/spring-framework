package org.springframework.dependency.injection.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * @author ：sjq
 * @date ：Created in 2022/11/18 16:56
 * @description：用户组扩展Qualifier注解进行分组
 * @modified By：
 * @version: $
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier
public @interface UserGroup {
}
