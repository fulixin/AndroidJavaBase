package com.fu.java;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fu.base.activity.BaseActivity;
import com.fu.base.adapter.CommAdapter;
import com.fu.base.adapter.CommHeaderImpl;
import com.fu.base.annotation.ViewById;
import com.fu.base.view.SwipeListView;
import com.fu.incrementupdate.update.ApkUtils;
import com.fu.incrementupdate.update.Diffutils;
import com.fu.permissionlibrary.IPermissionCallBackInface;
import com.fu.permissionlibrary.PermissionUtil;

import java.io.File;
import java.util.ArrayList;


/**
 * Created by fulixin on 2017/7/20.
 */

public class MainActivity extends BaseActivity {
    @ViewById(viewId = R.id.id_main_button_cope, onClick = true)
    private Button button;

    private String mPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;


    @Override
    protected void initialzie() {
        PermissionUtil.checkPermission(this, new String[]{"android.permission.INTERNET"}, new IPermissionCallBackInface() {
            @Override
            public void requestConfirm() {
                Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void requestCancel(ArrayList<String> permissions) {
                Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void requestCancelAgain() {

            }

            @Override
            public void requestFailed() {

            }
        });
        update();
//        listview();
    }

    @Override
    protected View layoutView() {
        return viewByViewId(R.layout.activity_main);
    }

    @Override
    protected void onViewClick(View v) {
        System.out.print("但继乐是见");
    }

    private void listview() {
        SwipeListView l = new SwipeListView(this);
        setContentView(l);
        ArrayList<Object> datas = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            datas.add("数据源" + i);
            datas.add(true);
        }
        l.setAdapter(new CommAdapter<Object>(this, datas) {
            @Override
            public void initdata(CommHeaderImpl commHeader, Object item, int position) {
                if (item instanceof String) {
                    ((TextView) commHeader.getConvertView().findViewById(R.id.id_main_item_textview_show)).setText(item.toString());
                } else if (item instanceof Boolean) {
                    ((TextView) commHeader.getConvertView().findViewById(R.id.id_main_item_textview_show)).setText("boolean型数据：" + item.toString());
                }
            }

            @Override
            public int layoutId(Object item) {
                if (item instanceof String) {
                    return R.layout.activity_main_item;
                } else if (item instanceof Boolean) {
                    return R.layout.activity_main_item1;
                }
                return 0;
            }

            @Override
            public int layoutRightId(Object item) {
                if (item instanceof String) {
                    return R.layout.activity_main_item_right;
                } else if (item instanceof Boolean) {
                    return R.layout.activity_main_item1_right;
                }
                return 0;
            }

            @Override
            public int ViewTypeCount() {
                return 2;
            }

            @Override
            public int viewTypeMap(Object item) {
                if (item instanceof String) {
                    return 0;
                } else if (item instanceof Boolean) {
                    return 1;
                }
                return 0;
            }
        });
    }

    private void update() {
        findViewById(R.id.id_main_button_cope).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Diffutils.generateDiffApk(ApkUtils.extract(MainActivity.this), mPath + "appNew1.apk", mPath + "app3.patch");
            }
        });
        findViewById(R.id.id_main_button_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Diffutils.mergeDiffApk(ApkUtils.extract(MainActivity.this), mPath + "appNew2.apk", mPath + "app3.patch");
            }
        });
        findViewById(R.id.id_main_button_install).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.setDataAndType(Uri.fromFile(new File(mPath + "appNew2.apk")),
                        "application/vnd.android.package-archive");
                startActivity(i);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtil.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
