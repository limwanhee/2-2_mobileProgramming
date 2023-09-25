package com.example.w04work;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "임완희", Toast.LENGTH_SHORT).show();
            }
        });
        Button btn2 = (Button)findViewById(R.id.button5);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "202207016", Toast.LENGTH_SHORT).show();
            }
        });
        Button btn3 = (Button)findViewById(R.id.button6);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn3.setText("경기도 부천시 괴안동");

            }
        });
        Button btn4 = (Button)findViewById(R.id.button7);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "010-2476-2816", Toast.LENGTH_SHORT).show();
            }
        });
        Button btn5 = (Button)findViewById(R.id.button8);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "안녕하세요!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}