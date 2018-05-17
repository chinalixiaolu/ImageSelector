package com.lixiaolu.lxlimageselector.loader;

import android.app.Activity;
import android.widget.ImageView;

import java.io.Serializable;


/**
 *
 * Created by li
 * 邮箱：chinalixiaolu@163.com
 * 日期：2016/11/24
 * 修改：version v1.0
 * 此类的作用： ImageLoader抽象类，外部需要实现这个类去加载图片， 尽力减少对第三方库的依赖，所以这么干了
 */
public interface ImageLoader extends Serializable {

    void displayImage(Activity activity, String path, ImageView imageView, int width, int height);

    void displayImagePreview(Activity activity, String path, ImageView imageView, int width, int height);

    void clearMemoryCache();
}
