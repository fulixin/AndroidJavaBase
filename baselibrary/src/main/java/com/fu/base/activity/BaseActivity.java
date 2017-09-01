package com.fu.base.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.fu.base.annotation.ViewById;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by fulixin on 2017/8/30.
 */

public abstract class BaseActivity extends AppCompatActivity {
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
        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ViewById.class)) {
                try {
                    ViewById viewById = field.getAnnotation(ViewById.class);
                    int viewId = viewById.viewId();
                    field.setAccessible(true);
                    if (viewId > 0) {
                        field.set(this, this.findViewById(viewId));
                    }
                    if (viewById.onClick()) {
                        Method method = getClass().getMethod("setOnClickListener", View.OnClickListener.class);
                        method.setAccessible(true);
                        method.invoke(field.get(this), onclickListener);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                try {
//                } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                }
            }
        }
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
