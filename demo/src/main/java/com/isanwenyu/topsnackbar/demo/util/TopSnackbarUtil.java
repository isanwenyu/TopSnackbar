package com.isanwenyu.topsnackbar.demo.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.isanwenyu.topsnackbar.TopSnackbar;


/**
 * <pre>
 * topSnackbar工具类
 * Created by isanwenyu on 2016/3/21.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 * </pre>
 */
public class TopSnackbarUtil {
    public static final int COLOR_SUCCESS = android.R.color.holo_green_dark;
    public static final int COLOR_FAIL = android.R.color.holo_red_light;

    /**
     * 显示错误信息
     *
     * @param view    viewToken
     * @param msgText 消息文本
     * @return TopSnackbar TopSnackbar对象
     */
    public static TopSnackbar showFail(View view, String msgText) {
        return showFail(view, msgText, null, null);
    }

    /**
     * 显示错误信息并设置显示隐藏回调接口
     *
     * @param view     viewToken
     * @param msgText  消息文本
     * @param callback 显示隐藏的回调接口
     * @return TopSnackbar TopSnackbar对象
     */
    public static TopSnackbar showFail(View view, String msgText, TopSnackbar.Callback callback) {
        return showFail(view, msgText, null, null, callback);
    }

    /**
     * 显示错误信息并有响应文本及点击事件
     *
     * @param view            token
     * @param msgText         消息文本
     * @param actionText      响应文本
     * @param onClickListener 响应事件
     * @return TopSnackbar TopSnackbar对象
     */
    public static TopSnackbar showFail(View view, String msgText, String actionText, View.OnClickListener onClickListener) {
        return showFail(view, msgText, actionText, onClickListener, null);
    }

    /**
     * 显示错误信息的最终实现类
     *
     * @param view            token
     * @param msgText         消息文本
     * @param actionText      响应文本
     * @param onClickListener 响应事件
     * @param callback        显示隐藏的回调
     * @return TopSnackbar TopSnackbar对象
     */
    public static TopSnackbar showFail(View view, String msgText, String actionText, View.OnClickListener onClickListener, TopSnackbar.Callback callback) {
        TopSnackbar snackbar = getTopSnackbar(view, msgText, actionText, onClickListener, callback).setIcon(com.isanwenyu.topsnackbar.R.drawable.ic_info_outline_white_18dp).setBackGround(COLOR_FAIL);
        snackbar.show();
        return snackbar;
    }

    /**
     * 显示成功信息
     *
     * @param view    viewToken
     * @param msgText 消息文本
     * @return TopSnackbar TopSnackbar对象
     */
    public static TopSnackbar showSuccess(View view, String msgText) {
        return showSuccess(view, msgText, null, null);
    }

    /**
     * 显示成功信息并设置显示隐藏回调
     *
     * @param view     viewToken
     * @param msgText  消息文本
     * @param callback 显示隐藏的毁掉接口
     * @return TopSnackbar TopSnackbar对象
     */
    public static TopSnackbar showSuccess(View view, String msgText, TopSnackbar.Callback callback) {
        return showSuccess(view, msgText, null, null, callback);
    }

    /**
     * 显示成功信息
     *
     * @param view            token
     * @param msgText         消息文本
     * @param actionText      响应文本
     * @param onClickListener 响应事件
     * @return TopSnackbar TopSnackbar对象
     */
    public static TopSnackbar showSuccess(View view, String msgText, String actionText, View.OnClickListener onClickListener) {
        return showSuccess(view, msgText, actionText, onClickListener, null);
    }

    /**
     * 显示成功信息的最终实现类
     *
     * @param view            token
     * @param msgText         消息文本
     * @param actionText      响应文本
     * @param onClickListener 响应事件
     * @param callback        回调显示或隐藏
     * @return TopSnackbar TopSnackbar对象
     */
    public static TopSnackbar showSuccess(View view, String msgText, String actionText, View.OnClickListener onClickListener, TopSnackbar.Callback callback) {
        TopSnackbar snackbar = getTopSnackbar(view, msgText, actionText, onClickListener, callback).setIcon(com.isanwenyu.topsnackbar.R.drawable.ic_check_circle_white_18dp).setBackGround(COLOR_SUCCESS);
        snackbar.show();
        return snackbar;
    }

    /**
     * 获取TopSnackBar 单一实现
     *
     * @param view            token
     * @param msgText         消息文本
     * @param actionText      响应文本
     * @param onClickListener 响应事件
     * @param callback        显示隐藏的回调
     * @return TopSnackbar TopSnackbar对象
     */
    @NonNull
    public static TopSnackbar getTopSnackbar(View view, String msgText, String actionText, View.OnClickListener onClickListener, TopSnackbar.Callback callback) {
        return TopSnackbar.make(view, msgText, hasAction(actionText, onClickListener) ? TopSnackbar.LENGTH_LONG : TopSnackbar.LENGTH_SHORT).setAction(actionText, onClickListener).setCallback(callback).setLayoutHeight(view.getMeasuredHeight());
    }

    /**
     * 根据传入的参数判断TopSnackbar是否包含action动作
     *
     * @param actionText      动作文本
     * @param onClickListener 动作监听
     * @return true:包含动作 false:不包含
     */
    private static boolean hasAction(String actionText, View.OnClickListener onClickListener) {
        return !TextUtils.isEmpty(actionText) && onClickListener != null;
    }

}
