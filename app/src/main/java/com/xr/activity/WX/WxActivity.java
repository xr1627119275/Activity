package com.xr.activity.WX;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xr.activity.Fragment.ContactFragment;
import com.xr.activity.Fragment.DiscoverFragment;
import com.xr.activity.Fragment.MeFragment;
import com.xr.activity.Fragment.WxFragment;
import com.xr.activity.R;

public class WxActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_wx;
    private Button btn_contact;
    private Button btn_discover;
    private Button btn_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx);
        btn_wx = findViewById(R.id.btn_wx);
        btn_contact = findViewById(R.id.btn_contact);
        btn_discover = findViewById(R.id.btn_discover);
        btn_me = findViewById(R.id.btn_me);
        btn_wx.setOnClickListener(this);
        btn_contact.setOnClickListener(this);
        btn_discover.setOnClickListener(this);
        btn_me.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.btn_wx:
                transaction.replace(R.id.ll,new WxFragment());
                break;
            case R.id.btn_contact:
                transaction.replace(R.id.ll,new ContactFragment());
                break;
            case R.id.btn_discover:
                transaction.replace(R.id.ll,new DiscoverFragment());
                break;
            case R.id.btn_me:
                transaction.replace(R.id.ll,new MeFragment());
                break;
        }
        transaction.commit();
    }
}
