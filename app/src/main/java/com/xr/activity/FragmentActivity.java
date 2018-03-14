package com.xr.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.xr.activity.Fragment.Fragment1;
import com.xr.activity.Fragment.Fragment2;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
//        if(height>width){
//            transaction.replace(android.R.id.content,new Fragment1());
//        }else{
//            transaction.replace(android.R.id.content,new Fragment2());
//        }
        transaction.replace(R.id.ll1,new Fragment1(),"f1");
        transaction.replace(R.id.ll2,new Fragment2(),"f2");
        transaction.commit();
    }
}
