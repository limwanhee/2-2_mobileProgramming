package com.example.w9work2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText edtAngle;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경");
        edtAngle = (EditText) findViewById(R.id.editAngle);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemRotate) {
            imageView1.setRotation(Float.parseFloat(edtAngle.getText().toString()));
        } else if (item.getItemId() == R.id.item1) {
            imageView1.setImageResource(R.drawable.jeju1);
        } else if (item.getItemId() == R.id.item2) {
            imageView1.setImageResource(R.drawable.jeju2);
        } else if (item.getItemId() == R.id.item3) {
            imageView1.setImageResource(R.drawable.jeju3);
        } else {
            return false;
        }
        return true;
    }
}