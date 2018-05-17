package com.lixiaolu.lxlimageselector.util;

import android.content.Context;

/**
 * 用于解决provider冲突的util

 *
 * Created by li
 * 邮箱：chinalixiaolu@163.com
 * 日期：2016/11/24
 * 修改：version v1.0
 * 此类的作用：
 */

public class ProviderUtil {

    public static String getFileProviderName(Context context){
        return context.getPackageName()+".provider";
    }
}
