package com.xr.activity.Anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.xr.activity.R;

public class TweenAnimActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_anim);
        iv = findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点我",Toast.LENGTH_SHORT).show();
            }
        });
    }


    //透明效果
    public void click1(View view) {
//        AlphaAnimation aa = new AlphaAnimation(1.0f,0.0f);
//        aa.setDuration(2000);
//        aa.setRepeatCount(1);
//        aa.setRepeatMode(Animation.REVERSE);
        Animation aa = AnimationUtils.loadAnimation(this, R.anim.alpha);
        iv.startAnimation(aa);
    }

    public void click2(View view) {
//        RotateAnimation ra = new RotateAnimation(0, 360);
    //        RotateAnimation ra = new RotateAnimation(0, 360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
    //        ra.setDuration(2000);
    //        ra.setRepeatCount(1);
    //        ra.setRepeatMode(Animation.REVERSE);
        Animation ra = AnimationUtils.loadAnimation(this, R.anim.rotate);
        iv.startAnimation(ra);
    }

    public void click3(View view) {
//        ScaleAnimation sa = new ScaleAnimation(1.0f,2.0f,1.0f,2.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        sa.setDuration(2000);
//        sa.setRepeatCount(1);
//        sa.setRepeatMode(Animation.REVERSE);
        Animation sa = AnimationUtils.loadAnimation(this, R.anim.scale);
        iv.startAnimation(sa);
    }

    public void click4(View view) {
//        TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.2f);
//        ta.setDuration(2000);
//        ta.setFillAfter(true);
//        ta.setRepeatCount(1);
//        ta.setRepeatMode(Animation.REVERSE);
        Animation ta = AnimationUtils.loadAnimation(this, R.anim.translate);
        iv.startAnimation(ta);
    }

    public void click5(View view) {
    //        AnimationSet animationSet = new AnimationSet(true);
    //        AlphaAnimation aa = new AlphaAnimation(1.0f,0.0f);
    //        aa.setDuration(2000);
    //        aa.setRepeatCount(1);
    //        aa.setRepeatMode(Animation.REVERSE);
    //        RotateAnimation ra = new RotateAnimation(0, 360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
    //        ra.setDuration(2000);
    //        ra.setRepeatCount(1);
    //        ra.setRepeatMode(Animation.REVERSE);
    //        ScaleAnimation sa = new ScaleAnimation(1.0f,2.0f,1.0f,2.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
    //        sa.setDuration(2000);
    //        sa.setRepeatCount(1);
    //        sa.setRepeatMode(Animation.REVERSE);
    //        animationSet.addAnimation(aa);
    //        animationSet.addAnimation(ra);
//        animationSet.addAnimation(sa);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
        iv.setAnimation(animation);
    }
}
