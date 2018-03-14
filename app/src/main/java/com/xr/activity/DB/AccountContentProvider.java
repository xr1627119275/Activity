package com.xr.activity.DB;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class AccountContentProvider extends ContentProvider {
    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int QUERYSUCCESS=0;
    private static final int INSERTSUCCESS=1;
    private static final int DELETESUCCESS=2;
    private static final int UPDATESUCCESS=3;

    static {
        sURIMatcher.addURI("com.xr.AccountContentProvider", "query", QUERYSUCCESS);
        sURIMatcher.addURI("com.xr.AccountContentProvider", "insert", INSERTSUCCESS);
        sURIMatcher.addURI("com.xr.AccountContentProvider", "delete", DELETESUCCESS);
        sURIMatcher.addURI("com.xr.AccountContentProvider", "update", UPDATESUCCESS);
    }

    private MyOpenHelper myOpenHelper;

    public AccountContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if(sURIMatcher.match(uri)==DELETESUCCESS){
            SQLiteDatabase db = myOpenHelper.getReadableDatabase();
            int delete = db.delete("info", selection, selectionArgs);
            db.close();
            getContext().getContentResolver().notifyChange(uri,null);
            return delete;

        }
        throw new IllegalArgumentException("Uri路径不匹配");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if(sURIMatcher.match(uri)==INSERTSUCCESS){
            SQLiteDatabase db = myOpenHelper.getReadableDatabase();
            long insert = db.insert("info", null, values);
            if(insert>0) {
                getContext().getContentResolver().notifyChange(uri, null);
            }
            Uri uri1 = Uri.parse("com.xixi/" + insert);
            return uri1;
        }
        throw new IllegalArgumentException("Uri路径不匹配");
    }

    @Override
    public boolean onCreate() {
        myOpenHelper = new MyOpenHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

       if(sURIMatcher.match(uri)==QUERYSUCCESS){
           SQLiteDatabase db = myOpenHelper.getReadableDatabase();
           Cursor info = db.query("info", projection, selection, selectionArgs, null, null, sortOrder);
           getContext().getContentResolver().notifyChange(uri,null);
           return info;

       }
       throw new IllegalArgumentException("Uri路径不匹配");

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        if(sURIMatcher.match(uri)==UPDATESUCCESS){
            SQLiteDatabase db = myOpenHelper.getReadableDatabase();
            int update = db.update("info",values, selection, selectionArgs);
            db.close();
            if(update>0) {
                getContext().getContentResolver().notifyChange(uri, null);
            }
            return update;

        }
        throw new IllegalArgumentException("Uri路径不匹配");
    }
}
