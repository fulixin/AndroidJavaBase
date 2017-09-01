package com.fu.permissionlibrary;

import java.util.ArrayList;

/**
 * 权限申请
 * Created by fulixin on 2017/8/24.
 */

public interface IPermissionInface {
    public final int myRequestCode=3;
    /**
     * 审核权限
     *
     * @param strs
     */
    ArrayList<String> checkPermission(String[] strs);

    /**
     * 申请权限
     *
     * @param strs
     */
    void requestPermission(String[] strs);
}
