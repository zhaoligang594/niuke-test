package com.breakpoint.annotation;

import java.lang.annotation.*;

/**
 * 执行成功
 *
 * @author :breakpoint/赵立刚
 * create on 2020/07/10
 */
@Repeatable()
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Success {
}
