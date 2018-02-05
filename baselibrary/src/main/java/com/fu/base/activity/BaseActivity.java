package com.fu.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fu.base.annotation.ViewById;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by fulixin on 2017/8/30.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private ArrayList<Field> fieldList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutView());
        init();
    }

    private void init() {
//        initializeLayout();
        initialzie();
    }

    protected abstract void initialzie();

    private void initializeLayout() {
        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();// 获得Activity中声明的字段
        for (Field field : fields) {
            if (field.isAnnotationPresent(ViewById.class)) {
                try {
                    ViewById viewById = field.getAnnotation(ViewById.class);
                    int viewId = viewById.viewId();
                    field.setAccessible(true);
                    if (viewId > 0) {
                        field.set(this, this.findViewById(viewId));
                    }
                    if (!viewById.isNull())
                        fieldList.add(field);
                    if (viewById.onClick()) {
                        //通过类的.class属性获取
                        Class<View> clz = View.class;
                        Method method = clz.getMethod("setOnClickListener", new Class[]{View.OnClickListener.class});
                        method.setAccessible(true);
                        method.invoke(this.findViewById(viewId), onclickListener);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isVerify() {
        for (Field field : fieldList) {
            try {
                String str = "";
                if (((View) (field.get(this))) instanceof TextView) {
                    str = ((TextView) (field.get(this))).getText().toString();
                } else if (((View) (field.get(this))) instanceof EditText) {
                    str = ((EditText) (field.get(this))).getText().toString();
                }
                if (str.equals("")) {
                    Toast.makeText(this, field.getAnnotation(ViewById.class).message(), Toast.LENGTH_SHORT).show();
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    protected abstract View layoutView();

    protected abstract void onViewClick(View v);

    public View viewByViewId(int viewId) {
        return LayoutInflater.from(this).inflate(viewId, null);
    }


    private View.OnClickListener onclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onViewClick(v);
        }
    };
}
