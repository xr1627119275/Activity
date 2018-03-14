package com.xr.activity.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xr.activity.R;

/**
 * Created by 16271 on 2018/3/13.
 */

public class Fragment2 extends Fragment {

    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, null);
        tv = view.findViewById(R.id.tv);
        return view;
    }

    public void setText(String content){
        tv.setText(content);
    }
}
