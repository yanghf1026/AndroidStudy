package com.example.touchevent;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class HatView extends View {
    public float bitmapX;
    public float bitmapY;
    public HatView(Context context){
        super(context);
        bitmapX = 65;
        bitmapY = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        //根据图片生成位图图像
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.hat);
        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);
        if(bitmap.isRecycled()){//判断图片是否强制回收
            bitmap.recycle();//强制回收图片
        }
    }
}
