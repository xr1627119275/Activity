package com.xr.activity.PersonResult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xr.activity.MainActivity;
import com.xr.activity.R;

public class Main2Activity extends AppCompatActivity {

    private EditText et_name;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et_name = findViewById(R.id.et_name);
        group = findViewById(R.id.rg_group);
    }

    public void click(View view) {
        String name = et_name.getText().toString().trim();
        int sex=0;
        if(TextUtils.isEmpty(name)){
            Toast.makeText(getApplicationContext(),"用户名不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        int radioButtonId = group.getCheckedRadioButtonId();
//        String sex="";
        switch (radioButtonId){
            case R.id.rb_female:
                sex =2;
                break;
            case R.id.rb_male:
                sex=1;
                break;
            case R.id.rb_other:
                sex =3;
                break;
        }
        if(sex==0){
            Toast.makeText(getApplicationContext(),"请选择性别",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("sex",sex);
        startActivity(intent);
    }
}
