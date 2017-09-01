package com.fu.incrementupdate.update;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * Created by fulixin on 2017/8/16.
 */

public class ApkUtils {
    /**
     * 获取安装包路径
     *
     * @param context
     * @return
     */
    public static String extract(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
        String apkPath = applicationInfo.sourceDir;
        return apkPath;
    }
}
