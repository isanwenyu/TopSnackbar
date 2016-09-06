package com.isanwenyu.topsnackbar.demo;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.isanwenyu.topsnackbar.TopSnackbar;
import com.isanwenyu.topsnackbar.demo.util.StatusBarCompat;
import com.isanwenyu.topsnackbar.demo.util.TopSnackbarUtil;

/**
 * 带title的基础布局处理
 * Created by isanwenyu on 2016/2/24.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 */
public class BaseToolbarActivity extends AppCompatActivity {

    public static final int TOOLBAR_DEFAULT = 668;//默认状态
    public static final int TOOLBAR_ERROR_HINT = 813;//错误提示
    public static final int TOOLBAR_SUCCESS_HINT = 170;//成功提示
    protected Toolbar mTitleBar;//标题栏
    /**
     * toolbar的状态
     */
    private int toobarTitleState = TOOLBAR_DEFAULT;
    private View mStatusBar;//状态栏布局对象
    /**
     * TopSnackbar回调
     */
    private TopSnackbar.Callback mCallBack = new TopSnackbar.Callback() {
        @Override
        public void onDismissed(TopSnackbar snackbar, @TopSnackbar.Callback.DismissEvent int event) {
            super.onDismissed(snackbar, event);
            if (event != TopSnackbar.Callback.DISMISS_EVENT_CONSECUTIVE) {
                if (mStatusBar != null && mStatusBar.getTag() == snackbar) {
                    //状态栏对象标记为当前snackbar才重置状态栏背景
                    setStatusBarBackground(R.color.colorPrimaryDark);
                }
            }
        }

        @Override
        public void onShown(TopSnackbar snackbar) {
            super.onShown(snackbar);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        refreshToobarTitleState(toobarTitleState, String.valueOf(getTitle()));
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        View contentView = getLayoutInflater().inflate(layoutResID, null);
        initToolbar(contentView);
        setContentView(contentView);
    }

    /**
     * 初始化带toolbar的布局
     *
     * @param contentView
     */
    private void initToolbar(View contentView) {
        mTitleBar = (Toolbar) contentView.findViewById(R.id.toolbar);
    }

    /**
     * 根据状态刷新toolbar的状态并弹出头部提示条
     *
     * @param toolbarState <br>
     *                     TOOLBAR_DEFAULT  //常用状态<br>
     *                     TOOLBAR_ERROR_HINT  //错误提示<br>
     *                     TOOLBAR_SUCCESS_HINT  //成功提示<br>
     * @param hintMsg      TopSnackbar提示信息
     */
    protected void refreshToobarTitleState(int toolbarState, String hintMsg) {
        this.toobarTitleState = toolbarState;
        switch (toolbarState) {
            case TOOLBAR_SUCCESS_HINT:
                mStatusBar = setStatusBarBackground(TopSnackbarUtil.COLOR_SUCCESS);
                TopSnackbar successSnackbar = TopSnackbarUtil.showSuccess(mTitleBar, hintMsg, mCallBack);
                if (mStatusBar != null) {
                    //关联statusBar与当前snackbar
                    mStatusBar.setTag(successSnackbar);
                }
                break;
            case TOOLBAR_ERROR_HINT:
                mStatusBar = setStatusBarBackground(TopSnackbarUtil.COLOR_FAIL);
                TopSnackbar errorSnackbar = TopSnackbarUtil.showFail(mTitleBar, hintMsg, mCallBack);
                if (mStatusBar != null) {
                    //关联statusBar与当前snackbar
                    mStatusBar.setTag(errorSnackbar);
                }
                break;
        }

    }

    /**
     * 刷新带动作的提示头布局
     *
     * @param hintMsg         提示信息
     * @param actionText      动作文本
     * @param onClickListener 动作点击事件监听器
     */
    protected void refreshToobarTitleStateWithAction(String hintMsg, String actionText, View.OnClickListener onClickListener) {
        mStatusBar = setStatusBarBackground(TopSnackbarUtil.COLOR_FAIL);
        TopSnackbar actionSnackbar = TopSnackbarUtil.showFail(mTitleBar, hintMsg, actionText, onClickListener, mCallBack);
        if (mStatusBar != null) {
            //关联statusBar与当前snackbar
            mStatusBar.setTag(actionSnackbar);
        }
    }

    /**
     * 刷新状态栏颜色
     *
     * @param bg_color
     * @return 状态栏单例对象
     */
    protected View setStatusBarBackground(final int bg_color) {
        return StatusBarCompat.setBackground(this, bg_color);
    }
}