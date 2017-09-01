package com.fu.permissionlibrary.impl;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.fu.permissionlibrary.IPermissionCallBackInface;
import com.fu.permissionlibrary.IPermissionResultBackInface;

import java.util.ArrayList;

/**
 * Created by fulixin on 2017/8/24.
 */

public class PermissionResultBackImpl implements IPermissionResultBackInface {
    private Context mContext;
    private IPermissionCallBackInface iPermissionCallBackInface;

    public PermissionResultBackImpl(Context mContext, IPermissionCallBackInface iPermissionCallBackInface) {
        this.mContext = mContext;
        this.iPermissionCallBackInface = iPermissionCallBackInface;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case myRequestCode: {
                ArrayList<String> array = new ArrayList<>();
                if (grantResults.length > 0) {
                    for (String str : permissions) {
                        if (!checkPermission(str)) {
                            array.add(str);
                        }
                    }
                }
                if (array.size() == 0) {
                    //申请通过
                    iPermissionCallBackInface.requestConfirm();
                } else {
                    //申请失败
                    iPermissionCallBackInface.requestCancel(array);
//                    //是否需要向用户解释申请的原因，在用户点击拒绝后，弹出dialog，给用户解释
//                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) mContext,
//                            Manifest.permission.ACCESS_FINE_LOCATION))

                }
            }
        }
    }

    @Override
    public ArrayList<String> checkPermission(String[] strs) {
        ArrayList<String> array = new ArrayList<>();
        for (String str : strs) {
            if (!checkPermission(str)) {
                array.add(str);
            }
        }
        return array;
    }

    /**
     * 权限检查
     *
     * @param permission
     * @return
     */
    public boolean checkPermission(@NonNull String permission) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        } else {
            return ContextCompat.checkSelfPermission(mContext, permission) == PackageManager.PERMISSION_GRANTED;
        }
    }

    @Override
    public void requestPermission(String[] strs) {
        ActivityCompat.requestPermissions((Activity) mContext,
                strs,
                myRequestCode);
    }
}
