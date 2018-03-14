package com.xr.activity;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ObserverActivity extends AppCompatActivity {
    private static final String TAG = "ObserverActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
        Uri uri = Uri.parse("content://com.xr.AccountContentProvider/");
        getContentResolver().registerContentObserver(uri, true,new MyContentOberver(new Handler()));
    }
    
    class MyContentOberver extends ContentObserver{

        /**
         * Creates a content observer.
         *
         * @param handler The handler to run {@link #onChange} on, or null if none.
         */
        public MyContentOberver(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            Log.d(TAG, "onChange: ");
            super.onChange(selfChange);
        }
    }
}
