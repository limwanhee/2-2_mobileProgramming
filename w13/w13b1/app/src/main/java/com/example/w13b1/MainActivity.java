package com.example.w13b1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final static int LINE = 1, CIRCLE = 2, RECTANGLE = 3;
    static int curShape = LINE;
    static int curColor = Color.DKGRAY;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        setTitle("간단 그림판 (개선)");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        menu.add(0, 3, 0, "사각형 그리기");
        SubMenu sMenu = menu.addSubMenu("색상 변경 >>");
        sMenu.add(0, 4, 0, "빨강");
        sMenu.add(0, 5, 0, "초록");
        sMenu.add(0, 6, 0, "파랑");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case 1:
                curShape = LINE; // 선
                return true;
            case 2:
                curShape = CIRCLE; // 원
                return true;
            case 3:
                curShape = RECTANGLE; // 사각형
                return true;
            case 4:
                curColor = Color.RED;
                return true;
            case 5:
                curColor = Color.GREEN;
                return true;
            case 6:
                curColor = Color.BLUE;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private static class MyGraphicView extends View {
        Myshape currentShape = null;
        ArrayList<Myshape> MyshapeArrayList = new ArrayList<>();
        public MyGraphicView(Context context) {
            super(context);
        }
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //위에서 정의한 Myshape객체인 currentShape 객체에 시작좌표, 끝좌표, 색상 지정
                    currentShape = new Myshape(curShape);
                    currentShape.color = curColor;
                    currentShape.startX = (int) event.getX();
                    currentShape.startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    currentShape.stopX = (int) event.getX();
                    currentShape.stopY = (int) event.getY();
                    this.invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    currentShape.stopX = (int) event.getX();
                    currentShape.stopY = (int) event.getY();
                    //손을 뗄 때 동적 리스트에 더해준다.
                    MyshapeArrayList.add(currentShape);
                    currentShape = null;
                    this.invalidate();
                    break;
            }
            return true;
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
//for each 문으로 MyshapeArrayList의 인덱스를 하나씩 호출
            for (Myshape currentShape : MyshapeArrayList) {
                paint.setColor(currentShape.color);
                drawShape(currentShape, canvas, paint);
            }
            if (currentShape != null) drawShape(currentShape, canvas, paint);
        }
        //그림을 그리는 함수
        private void drawShape(Myshape currentShape, Canvas canvas, Paint paint) {
            switch (currentShape.shape) {
                case LINE:
                    canvas.drawLine(currentShape.startX, currentShape.startY,
                            currentShape.stopX, currentShape.stopY, paint);
                    break;
                case CIRCLE:
                    int radius = (int) Math.sqrt(Math.pow(currentShape.stopX - currentShape.startX, 2) +
                            Math.pow(currentShape.stopY - currentShape.startY, 2));
                    canvas.drawCircle(currentShape.startX, currentShape.startY, radius, paint);
                    break;
                case RECTANGLE:
                    Rect rect = new Rect(currentShape.startX, currentShape.startY,
                            currentShape.stopX, currentShape.stopY);
                    canvas.drawRect(rect, paint);
                    break;
            }
        }
        //그린 도형들을 저장해 줄 때 필요한 함수를 만들어줬다.
        private static class Myshape {
            int shape, startX, startY, stopX, stopY, color;
            public Myshape(int shape) {
                this.shape = shape;
            }

//            paint.setColor(Color.GREEN); //첫번째 프로젝트
//            paint.setStrokeWidth(10);
//            canvas.drawLine(20, 40, 600, 20, paint); //초록색 선
//
//            paint.setColor(Color.BLUE);
//            paint.setStrokeWidth(10);
//            canvas.drawLine(20, 60, 600, 60, paint); // 파랑색 선
//
//            paint.setColor(Color.MAGENTA);
//            paint.setStrokeWidth(0);
//            paint.setStyle(Paint.Style.FILL); //색깔 채운
//            Rect rect1 = new Rect(20, 100, 20 + 200, 100 + 150);
//            canvas.drawRect(rect1, paint); //빨간 사각형 그리기
//
//            paint.setStyle(Paint.Style.STROKE);
//            Rect rect2 = new Rect(260, 100, 260 + 200, 100 + 200);
//            canvas.drawRect(rect2, paint);
//
//            RectF rect3 = new RectF(500, 100, 500 + 200, 100 + 200);
//            canvas.drawRoundRect(rect3, 40, 40, paint);
//
//            canvas.drawCircle(120, 440, 100, paint);
//
//            paint.setStrokeWidth(10);
//            Path path1 = new Path();
//            path1.moveTo(20, 580);
//            path1.lineTo(20 + 100, 580 + 100);
//            path1.lineTo(20 + 200, 580);
//            path1.lineTo(20 + 300, 580 + 100);
//            path1.lineTo(20 + 400, 580);
//
//            paint.setStrokeWidth(10);
//            path1.moveTo(20, 1000 - 100);
//            path1.lineTo(20, 1000 + 50);
//            path1.lineTo(20 + 100, 1000 + 50);
//
//            canvas.drawCircle(20 + 200, 1000 - 100, 10, paint);
//            path1.moveTo(20 + 200, 1000 - 50);
//            path1.lineTo(20 + 200, 1000 + 50);
//
//            path1.moveTo(20 + 300, 1000 + 50);
//            path1.lineTo(20 + 350, 1000 - 25);
//            path1.lineTo(20 + 400, 1000 + 50);
//            path1.lineTo(20 + 450, 1000 - 25);
//            path1.lineTo(20 + 500, 1000 + 50);
//
//
//            canvas.drawPath(path1, paint);
//            paint.setStrokeWidth(15);
//            paint.setTextSize(200);
//            canvas.drawText("안드로이드", 200, 850, paint);

        }
    }
}