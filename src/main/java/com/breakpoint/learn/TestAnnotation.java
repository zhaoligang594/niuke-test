package com.breakpoint.learn;

import org.jetbrains.annotations.Debug;

import java.lang.annotation.*;

/**
 * @author breakpoint/赵先生
 * 2020/11/24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
//@Inherited
public @interface TestAnnotation {
}
