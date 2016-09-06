package com.isanwenyu.topsnackbar.demo;

import android.os.Bundle;
import android.view.View;

/**
 * 主界面<br>
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 */
public class MainActivity extends BaseToolbarActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBarBackground(R.color.colorPrimaryDark);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_action:
                refreshToobarTitleStateWithAction("这是一个带有动作的TopSnackbar,balabalabalabalabala", "点我", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        refreshToobarTitleState(TOOLBAR_SUCCESS_HINT, "您刚才点击了带有动作的TopSnackbar");
                    }
                });
                break;
            case R.id.btn_success:
                refreshToobarTitleState(TOOLBAR_SUCCESS_HINT, "这是一个显示成功的TopSnackbar");
                break;
            case R.id.btn_fail:
                refreshToobarTitleState(TOOLBAR_ERROR_HINT, "这是一个显示失败的TopSnackbar");
                break;

        }
    }
}
