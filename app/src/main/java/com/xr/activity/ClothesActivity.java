package com.xr.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ClothesActivity extends AppCompatActivity {

    private ImageView iv;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        iv = findViewById(R.id.iv);
        Bitmap srcbitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pre19);
        final Bitmap alterbitmap = Bitmap.createBitmap(srcbitmap.getWidth(), srcbitmap.getHeight(), srcbitmap.getConfig());
        Paint paint = new Paint();
        final Canvas canvas = new Canvas(alterbitmap);
        canvas.drawBitmap(srcbitmap, new Matrix(), paint);
        iv.setImageBitmap(alterbitmap);


        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_MOVE:
                        for (int i = -70; i < 70; i++) {
                            for (int j = -70; j < 70; j++) {
                                if(Math.sqrt(i*i+j*j)<70){
                                    try {
                                        alterbitmap.setPixel((int) event.getX() + i, (int) event.getY() + j, Color.TRANSPARENT);
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        iv.setImageBitmap(alterbitmap);
                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                }

                return true;
            }
        });
    }


}
