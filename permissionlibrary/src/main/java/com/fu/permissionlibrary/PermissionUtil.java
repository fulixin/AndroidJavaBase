package com.fu.permissionlibrary;

import android.content.Context;

import com.fu.permissionlibrary.impl.PermissionResultBackImpl;

import java.util.ArrayList;

/**
 * 权限申请
 * Created by fulixin on 2017/8/24.
 */

public class PermissionUtil {
    private static IPermissionResultBackInface iPermissionResultBackInface;

    public PermissionUtil() {

    }

    public static void checkPermission(Context mContext, String[] permissions, IPermissionCallBackInface iPermissionCallBackInface) {
        iPermissionResultBackInface = new PermissionResultBackImpl(mContext, iPermissionCallBackInface);
        ArrayList<String> list = iPermissionResultBackInface.checkPermission(permissions);
        if (list.size() > 0) {
            iPermissionResultBackInface.requestPermission((String[]) list.toArray(new String[list.size()]));
        } else {
            iPermissionCallBackInface.requestConfirm();
        }
    }

    public static void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        iPermissionResultBackInface.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
