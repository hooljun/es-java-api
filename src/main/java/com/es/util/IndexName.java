package com.es.util;

import java.lang.annotation.*;
/**
 * elasticsearch创建索引和搜索使用的注解
 * @date 2019/8/12
 * @author luohaipeng
 */
@Documented
@Inherited
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface IndexName {

    String value() default "";
}
