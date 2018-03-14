package com.xr.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.xr.activity.DB.AccountContentProvider;
import com.xr.activity.DB.MyOpenHelper;

public class DBActivity extends AppCompatActivity {
    private static final String TAG = "DBActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        new AccountContentProvider();
//        MyOpenHelper myOpenHelper = new MyOpenHelper(getApplicationContext());
//        SQLiteDatabase db = myOpenHelper.getReadableDatabase();
//        Cursor info = db.query("info", null, null, null, null, null, null);
//        if (info!=null&&info.getCount()>0){
//            while(info.moveToNext()){
//                String name = info.getString(1);
//                String money = info.getString(2);
//                Log.d(TAG, name+"--"+money);
//            }
//        }else {
//            Log.d(TAG, "null-----------: ");
//        }
//        info.close();
    }
}
