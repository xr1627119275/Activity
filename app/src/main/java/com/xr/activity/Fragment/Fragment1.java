package com.xr.activity.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.xr.activity.R;

/**
 * Created by 16271 on 2018/3/13.
 */

public class Fragment1 extends Fragment {
    private Button btn1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
        btn1 = view.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"hhhh",Toast.LENGTH_SHORT).show();
                Fragment2 f2 = (Fragment2) getActivity().getFragmentManager().findFragmentByTag("f2");
                f2.setText("haha");
            }
        });
        return view;
    }
}
