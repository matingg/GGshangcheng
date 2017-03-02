package com.atguigu.ggshangcheng;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SubView extends LinearLayout{

    private ImageView iv_sub;
    private TextView tv_value;
    private ImageView iv_add;
    private int minValue = 1;
    private int maxValue = 10;
    private int value = 1;

    public SubView(Context context, AttributeSet attrs) {
        super(context, attrs);
         View.inflate(context , R.layout.activity_sub_view ,this);
        iv_sub = (ImageView) findViewById(R.id.iv_sub);
        iv_add = (ImageView) findViewById(R.id.iv_add);
        tv_value = (TextView) findViewById(R.id.tv_value);
//设置点击事件
        iv_sub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value > minValue) {
                    value -- ;
                }
                setValue(value);
                if(listener != null) {
                    listener.onNumberChanger(value);
                }
            }
        });
        //设置点击事件
        iv_add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               if(value < maxValue) {
                   value++;
               }
                setValue(value);
                if(listener != null) {
                    listener.onNumberChanger(value);
                }
            }

        });


        if (attrs != null) {
            //取出属性
            TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(context, attrs, R.styleable.AddSubView);
            int value = tintTypedArray.getInt(R.styleable.AddSubView_value, 0);
            if (value > 0) {
                setValue(value);
            }
            int minValue = tintTypedArray.getInt(R.styleable.AddSubView_minValue, 0);
            if (value > 0) {
                setMinValue(minValue);
            }
            int maxValue = tintTypedArray.getInt(R.styleable.AddSubView_maxValue, 0);
            if (value > 0) {
                setMaxValue(maxValue);
            }
            Drawable addDrawable = tintTypedArray.getDrawable(R.styleable.AddSubView_numberAddBackground);
            if (addDrawable != null) {
                iv_add.setImageDrawable(addDrawable);
            }
            Drawable subDrawable = tintTypedArray.getDrawable(R.styleable.AddSubView_numberSubBackground);
            if (subDrawable != null) {
                iv_sub.setImageDrawable(subDrawable);
            }
        }


    }




    public void setValue(int value) {
        this.value = value;
        tv_value.setText(value+"");
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }


    public int getValue() {
        return value;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    //定义一个接口
    public  interface  OnnumberChangerListener {
        public  void onNumberChanger(int value);
    }
    private  OnnumberChangerListener listener;

    public void setOnNumberChangerListener(OnnumberChangerListener listener){
        this.listener = listener;
    }

}
