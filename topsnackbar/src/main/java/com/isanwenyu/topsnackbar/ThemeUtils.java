package com.isanwenyu.topsnackbar;

import android.content.Context;
import android.content.res.TypedArray;

/**
 * <pre>
 * 检查主题工具类
 * Created by isanwenyu on 2016/3/21.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 * </pre>
 */
class ThemeUtils {

    private static final int[] APPCOMPAT_CHECK_ATTRS = {android.support.design.R.attr.colorPrimary};

    static void checkAppCompatTheme(Context context) {
        TypedArray a = context.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
        final boolean failed = !a.hasValue(0);
        if (a != null) {
            a.recycle();
        }
        if (failed) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme "
                    + "(or descendant) with the design library.");
        }
    }
}
