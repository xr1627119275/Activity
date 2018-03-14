package com.xr.activity.Sms;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.xr.activity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 16271 on 2018/3/7.
 */

public class ContactActivity extends AppCompatActivity {
    private ListView lv_contact;
    private List<Contact> contactlist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        lv_contact = findViewById(R.id.lv_contact);
        contactlist = new ArrayList<Contact>();
        for (int i = 0; i <10 ; i++) {
            Contact contact = new Contact();
            contact.setName("张三"+i);
            contact.setPhone("123123782"+i);
            contactlist.add(contact);
        }

        lv_contact.setAdapter(new MyAdapter());
        lv_contact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Contact Contact = (Contact) parent.getItemAtPosition(position);
                String phone = contactlist.get(position).getPhone();
//                Toast.makeText(getApplicationContext(),phone,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("phone",phone);
                setResult(10,intent);
                finish();
            }
        });
    }

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return contactlist.size();
        }

        @Override
        public Object getItem(int position) {
            return contactlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if(convertView ==null){
                view = View.inflate(getApplicationContext(), R.layout.contact_item, null);
            }else{
                view = convertView;
            }

            TextView tv_name = view.findViewById(R.id.tv_item_name);

            TextView tv_num = view.findViewById(R.id.tv_item_num);
            tv_name.setText(contactlist.get(position).getName());
            tv_num.setText(contactlist.get(position).getPhone());
            return view;
        }
    }
}
