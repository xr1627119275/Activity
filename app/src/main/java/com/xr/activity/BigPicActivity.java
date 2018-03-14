package com.xr.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class BigPicActivity extends AppCompatActivity {

    private ImageView iv;
    private int screenwidth;
    private int screenheight;
    private ImageView img_src;
    private ImageView img_copy;
    private float degress;
    @SuppressLint("HandlerLeak")
//    private Handler mhandler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            Bitmap copybitmap = (Bitmap) msg.obj;
//            img_copy.setImageBitmap(copybitmap);
//        }
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_pic);
        iv = findViewById(R.id.iv);
        img_src = findViewById(R.id.img_src);
        img_copy = findViewById(R.id.img_copy);
        final Bitmap srcbitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tomcat);
        img_src.setImageBitmap(srcbitmap);
        final Bitmap copybitmap = Bitmap.createBitmap(srcbitmap.getWidth(), srcbitmap.getHeight(), srcbitmap.getConfig());
        final Canvas canvas = new Canvas(copybitmap);
        final Paint paint = new Paint();
        final Matrix matrix = new Matrix();
        new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    degress += 5;



                    matrix.setRotate(degress, srcbitmap.getWidth() / 2, srcbitmap.getHeight() / 2);
                    matrix.setScale(.5f,.5f);
                    matrix.setTranslate(50,0);

                    canvas.drawBitmap(srcbitmap, matrix, paint);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            img_copy.setImageBitmap(copybitmap);
                        }

                    });
                    SystemClock.sleep(1000);
//                    Message message = Message.obtain();
//                    message.obj = copybitmap;
//                    mhandler.sendMessage(message);
                }
            }
        }.start();

//        for (int i = 1; i < 100; i++) {
//            copybitmap.setPixel(20 + i, 30, Color.RED);
//        }



        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        screenwidth = defaultDisplay.getWidth();
        screenheight = defaultDisplay.getHeight();
//        Point point = new Point();
//        defaultDisplay.getSize(point);
//        int width = point.x;
//        int height = point.y;
//        Toast.makeText(getApplicationContext(),screenwidth+"-"+screenheight,Toast.LENGTH_SHORT).show();
    }

    public void load(View view) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile("/sdcard/dog.jpg", options);
        int imgWidth = options.outWidth;
        int imgHeight = options.outHeight;
        int scale = 1;
        int scalex = imgWidth / screenwidth;
        int scaley = imgHeight / screenheight;
        if (scalex > scaley && scalex > scale) {
            scale = scalex;
        }
        if (scaley > scalex && scaley > scale) {
            scale = scaley;
        }
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile("/sdcard/dog.jpg", options);
        Toast.makeText(getApplicationContext(), "缩放比为" + scale, Toast.LENGTH_SHORT).show();

        iv.setImageBitmap(bitmap);
    }
}
