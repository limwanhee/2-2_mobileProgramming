package com.example.w14a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        setTitle("이미지 보기");
    }
    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.yuhan);
            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;


            Paint paint = new Paint();
            float[] array = { 2, 0, 0, 0, -25,
                              0, 2, 0, 0, -25,
                              0, 0, 2, 0, -25,
                              0, 0, 0, 1, 0 };
            BlurMaskFilter bMask;
            EmbossMaskFilter eMask;

            canvas.drawBitmap(picture, picX, picY - 500, null);

            ColorMatrix cm = new ColorMatrix(array);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));
            canvas.drawBitmap(picture, picX, picY, paint);

//            엠보싱
//            paint.setColor(Color.GRAY);
//            eMask = new EmbossMaskFilter(new float[] { 3, 3, 3 }, 0.5f, 5, 20);
//            paint.setMaskFilter(eMask);
//            canvas.drawCircle(cenX, cenY-600, 150, paint);
//
//            paint.setColor(Color.BLUE);
//            eMask = new EmbossMaskFilter(new float[] {10,3,3}, 0.5f, 5, 20);
//            paint.setMaskFilter(eMask);
//            canvas.drawCircle(cenX, cenY-300, 150, paint);
//
//            paint.setColor(Color.RED);
//            eMask = new EmbossMaskFilter(new float[] {3,10,3}, 0.5f, 5, 20);
//            paint.setMaskFilter(eMask);
//            canvas.drawCircle(cenX, cenY, 150, paint);
//
//            paint.setColor(Color.GREEN);
//            eMask = new EmbossMaskFilter(new float[] {3,3,10}, 0.5f, 5, 20);
//            paint.setMaskFilter(eMask);
//            canvas.drawCircle(cenX, cenY+300, 150, paint);


//            // NORMAL
//            bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
//            paint.setMaskFilter(bMask);
//            canvas.drawBitmap(picture, picX, picY, paint);
////          picture.recycle(); // 30 이전이면 heap에 할당하므로 호출 필수, 이후는 VM에 할당 (지금은 34를 사용해서 필요 없음) (2번 호출되면 앱이 오류남)

//            //INNER
//            bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.INNER);
//            paint.setMaskFilter(bMask);
//            canvas.drawBitmap(picture, picX, picY, paint);
////          picture.recycle();

//            // OUTER
//            bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.OUTER);
//            paint.setMaskFilter(bMask);
//            canvas.drawBitmap(picture, picX, picY, paint);
////          picture.recycle();

//            // SOLID
//            bMask = new BlurMaskFilter (30, BlurMaskFilter.Blur.SOLID);
//            paint.setMaskFilter(bMask);
//            canvas.drawBitmap(picture, picX, picY, paint);
////          picture.recycle();
//            picture = null; // 30이후 VM 할당은 자동으로 메모리 환원 가능 (지금은 34를 사용해서 필요 없음)

//사진 회전 이동하는 기술들
//          // 회전
//          canvas.rotate(15, cenX, cenY);
//          canvas.drawBitmap(picture, picX, picY, null);
//
//          // 이동
//          canvas.translate(-150, 200);
//          canvas.drawBitmap(picture, picX, picY, null);

//          // 확대
//          canvas.scale(2, 2, cenX, cenY);
//          canvas.drawBitmap(picture, picX, picY, null);

//          // 축소
//          canvas.scale(0.5f, 0.5f, cenX, cenY);
//          canvas.drawBitmap(picture, picX, picY, null);

//          // 기울이기
//          canvas.skew (1.3f, 1.3f);
//          canvas.drawBitmap(picture, picX, picY, null);
        }
    }
}