package com.fu.incrementupdate.update;

/**
 * 进行差分包的生成及合并
 * Created by fulixin on 2017/8/16.
 */

public class Diffutils {
    static {
        System.loadLibrary("native-lib");
    }


    /**
     * @param oldPath 旧的安装包路径
     * @param newPath 新的安装包路径
     * @param patchPath 差分包路径
     * @return 生成的结果
     */
    public static native int generateDiffApk(String oldPath, String newPath, String patchPath);

    /**
     * @param oldPath 旧的安装包路径
     * @param newPath 新的安装包路径
     * @param patchPath 差分包路径
     * @return 生成的结果
     */
    public static native int mergeDiffApk(String oldPath, String newPath, String patchPath);
}
