package com.fu.permissionlibrary;

/**
 * Created by fulixin on 2017/8/24.
 */

public interface IPermissionResultBackInface extends IPermissionInface{

    /**
     * 申请权限回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    void onRequestPermissionsResult(int requestCode,
                                    String permissions[], int[] grantResults);
}
