package com.xr.activity.Frame;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.xr.activity.R;

public class FrameanimActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frameanim);
        iv = findViewById(R.id.iv);
        iv.setBackgroundResource(R.drawable.my_anim);
        AnimationDrawable ad = (AnimationDrawable) iv.getBackground();
        ad.start();
    }
}
