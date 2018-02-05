package com.fu.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fulixin on 2017/8/30.
 */
// 表示用在字段上
@Target(ElementType.FIELD)
// 表示是在声明周期运行的
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewById {
    int viewId() default 0;

    boolean isNull() default true;

    String message() default "";
    boolean onClick() default false;
}
