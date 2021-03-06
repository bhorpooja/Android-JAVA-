package com.example.runtimechangespart2;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            ((ImageView)findViewById(R.id.imgVw)).setImageResource(R.drawable.ic_boy);
        }
        else if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            ((ImageView)findViewById(R.id.imgVw)).setImageResource(R.drawable.ic_bus);
        }
        else {
            ((ImageView)findViewById(R.id.imgVw)).setImageResource(R.drawable.ic_launcher_background);
        }
    }
}
