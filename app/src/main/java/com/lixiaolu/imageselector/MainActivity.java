package com.lixiaolu.imageselector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.lixiaolu.lxlimageselector.ImagePicker;
import com.lixiaolu.lxlimageselector.bean.ImageItem;
import com.lixiaolu.lxlimageselector.ui.ImageGridActivity;
import com.lixiaolu.lxlimageselector.view.CropImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImagePicker imagePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagePicker = ImagePicker.getInstance();


        findViewById(R.id.btn_single).setOnClickListener(this);
        findViewById(R.id.btn_limit).setOnClickListener(this);
        findViewById(R.id.btn_unlimited).setOnClickListener(this);
        findViewById(R.id.btn_clip).setOnClickListener(this);
        findViewById(R.id.btn_wx).setOnClickListener(this);
        findViewById(R.id.btn_singlecamear).setOnClickListener(this);
        findViewById(R.id.btn_circle).setOnClickListener(this);
        findViewById(R.id.btn_byself).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_single:
                //单选不带摄像头 不裁剪
                imagePicker.setImageLoader(new GlideImageLoader());
                imagePicker.setMultiMode(false);  //如果是多选  设置为true
                imagePicker.setShowCamera(false); // 是否带有摄像头显示
                imagePicker.setCrop(false); //是否裁剪
                imagePicker.setSaveRectangle(true);  // 是否暗战裁剪区域保存图片  如果设置为false  那么图片保存宽高 不生效
                imagePicker.setOutPutX(100);  //图片保存宽
                imagePicker.setOutPutY(100);//图片保存高

                Intent intent = new Intent(this, ImageGridActivity.class);
                intent.putExtra(ImageGridActivity.EXTRAS_IMAGES,images);
                //ImagePicker.getInstance().setSelectedImages(images);
                startActivityForResult(intent, 100);
                break;
            case R.id.btn_singlecamear:
                //单选带摄像头  不裁剪

                break;
            case R.id.btn_limit:
                //多选(最多9张)




                break;
            case R.id.btn_unlimited:
                //多选(不限数量)


                break;
            case R.id.btn_byself:
                //多选不限制数量

                break;
            case R.id.btn_clip:
                //单选并剪裁方形 并设置方形大小
                //单选不带摄像头 不裁剪
                imagePicker.setImageLoader(new GlideImageLoader());
                imagePicker.setMultiMode(false);  //如果是多选  设置为true
                imagePicker.setShowCamera(false); // 是否带有摄像头显示
                imagePicker.setCrop(true); //是否裁剪
                imagePicker.setStyle(CropImageView.Style.RECTANGLE);
                Integer width = Integer.valueOf(400);
                Integer height = Integer.valueOf(400);
                width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, getResources().getDisplayMetrics());
                height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height, getResources().getDisplayMetrics());
                imagePicker.setFocusWidth(width);
                imagePicker.setFocusHeight(height);
                // 是否暗照裁剪区域保存图片  如果设置为false  那么图片保存宽高 不生效  裁剪后的图片是否是矩形，否者跟随裁剪框的形状
                imagePicker.setSaveRectangle(true);


                Intent intent1 = new Intent(this, ImageGridActivity.class);
                intent1.putExtra(ImageGridActivity.EXTRAS_IMAGES,images);
                //ImagePicker.getInstance().setSelectedImages(images);
                startActivityForResult(intent1, 100);




                break;
            case R.id.btn_circle:
                //单选并剪裁圆形 并设置圆形直径


                break;
            case R.id.btn_wx:
                //仿微信



                break;


        }
    }

    ArrayList<ImageItem> images = null;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == 100) {
                images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                System.out.println(images.size()+"images.size");

            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
