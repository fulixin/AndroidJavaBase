package com.fu.okhttp.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by fulixin on 2017/9/11.
 */

public class TTypeUtils {
    public static String getTType(Class<?> clazz) {
        Type mySuperClassType = clazz.getGenericSuperclass();
        Type[] types = ((ParameterizedType) mySuperClassType).getActualTypeArguments();
        if (types != null && types.length > 0) {
            String[] TType = types[0].toString().split(" ");
            if (TType != null && TType.length > 1) {
                return TType[1];
            }
        }
        return null;
    }
}
