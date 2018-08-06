package com.guava.cache.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * Created by heshuanglin on 2017/12/4.
 */

@Documented
@Target(value = ElementType.METHOD)
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Log {

    String comments() default "";
    String author() default "lin";

}
