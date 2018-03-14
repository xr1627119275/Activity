package com.xr.activity.Sms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.xr.activity.R;

public class SmsTemplateActivity extends AppCompatActivity {

    private ListView lv_temp;
    String object[]={"我在开会，请稍后联系","我在吃饭，请稍后联系","我在开车，请稍后联系","我在调代码，请稍后联系"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_template);
        lv_temp = findViewById(R.id.lv_temp);
        lv_temp.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.item,object));
        lv_temp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String SmsContent = object[position];
                Intent intent = new Intent();
                intent.putExtra("content",SmsContent);
                setResult(20,intent);
                finish();

            }
        });
    }
}
