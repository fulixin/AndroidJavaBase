package com.fu.permissionlibrary;

import java.util.ArrayList;

/**
 * Created by fulixin on 2017/8/24.
 */

public interface IPermissionCallBackInface {
    /**
     * 申请成功
     */
    void requestConfirm();

    /**
     * 拒绝
     */
    void requestCancel(ArrayList<String> permissions);

    /**
     * 勾选不再提示并拒绝
     */
    void requestCancelAgain();

    /**
     * 在设置页面申请权限失败
     */
    void requestFailed();
}
