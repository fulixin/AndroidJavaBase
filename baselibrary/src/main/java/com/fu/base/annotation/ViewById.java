package com.fu.base.annotation;

/**
 * Created by fulixin on 2017/8/30.
 */

public @interface ViewById {
    int viewId() default 0;

    boolean onClick() default false;
}
