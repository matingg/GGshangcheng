package com.atguigu.ggshangcheng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  SubView av;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        av = (SubView) findViewById(R.id.sv_main);
       av.setOnNumberChangerListener(new SubView.OnnumberChangerListener() {
           @Override
           public void onNumberChanger(int value) {
               Toast.makeText(MainActivity.this, "value=="+value, Toast.LENGTH_SHORT).show();
           }
       });

    }


}
