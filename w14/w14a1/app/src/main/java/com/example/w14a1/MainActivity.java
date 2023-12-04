package com.example.w14a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity { //13주차에 했던거 자유 곡선 추가
    final static int LINE = 1, CIRCLE = 2, RECTANGLE = 3, FREE_LINE = 4;
    static int curShape = LINE;
    static int curColor = Color.DKGRAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(new MyGraphicView(this));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        setTitle("간단 그림판(개선)");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        menu.add(0, 3, 0, "사각형 그리기");
        menu.add(0, 4, 0, "자유곡선 그리기");
        SubMenu sMenu = menu.addSubMenu("색상 변경 >>");
        sMenu.add(0, 5, 0, "빨강");
        sMenu.add(0, 6, 0, "초록");
        sMenu.add(0, 7, 0, "파랑");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
                curShape = FREE_LINE; // 자유 곡선
                return true;
            case 5:
                curColor = Color.RED;
                return true;
            case 6:
                curColor = Color.GREEN;
                return true;
            case 7:
                curColor = Color.BLUE;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        Myshape currentShape = null;
        ArrayList<Myshape> MyshapeArrayList = new ArrayList<>();
        public MyGraphicView(Context context) {
            super(context);
        }

        //터치 이벤트 설정
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    currentShape = new Myshape(curShape);
                    currentShape.color = curColor;
                    if (curShape == FREE_LINE) {
                        currentShape.path.moveTo(event.getX(), event.getY());
                    } else {
                        currentShape.startX = (int) event.getX();
                        currentShape.startY = (int) event.getY();
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (curShape == FREE_LINE) {
                        currentShape.path.lineTo(event.getX(), event.getY());
                    } else {
                        currentShape.stopX = (int) event.getX();
                        currentShape.stopY = (int) event.getY();
                    }
                    this.invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    if (curShape != FREE_LINE) {
                        currentShape.stopX = (int) event.getX();
                        currentShape.stopY = (int) event.getY();
                    }
                    MyshapeArrayList.add(currentShape);
                    currentShape = null;
                    this.invalidate();
                    break;
            }
            return true;
        }
        private static class Myshape {
            int shape, startX, startY, stopX, stopY, color;
            Path path;
            public Myshape(int shape) {
                this.shape = shape;
                if (shape == FREE_LINE){
                    path = new Path();
                }
            }
        }
        @Override
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
            paint.setColor(curColor);

            switch (curShape) {
                case LINE:
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
                case CIRCLE:
                    int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2)
                            + Math.pow(stopY - startY, 2));
                    canvas.drawCircle(startX, startY, radius, paint);
                    break;
                case RECTANGLE:
                    Rect rect = new Rect(startX, startY, stopX, stopY);
                    canvas.drawRect(rect, paint);
                    break;
            }

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
                case FREE_LINE:
                    paint.setStyle(Paint.Style.STROKE);
                    canvas.drawPath(currentShape.path, paint);
                    break;
            }
        }
    }
}