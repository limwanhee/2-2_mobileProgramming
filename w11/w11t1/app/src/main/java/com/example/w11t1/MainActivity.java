package com.example.w11t1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnRead, btnWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnWrite = (Button) findViewById(R.id.btnWrite);
    btnWrite.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                FileOutputStream outFs = openFileOutput("yuhan.jpg", Context.MODE_PRIVATE);
                String str = "★안드로이드 파일처리 임완희♥";
                outFs.write(str.getBytes());
                outFs.close();
                Toast.makeText(getApplicationContext(), "file.txt가 생성됨", Toast.LENGTH_SHORT).show();
            }
            catch (IOException e){
                Toast.makeText(getApplicationContext(), "생성 오류" , Toast.LENGTH_SHORT).show();
            }
        }
    });
        btnRead.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileInputStream inFs = openFileInput("yuhan.jpg");
                    byte[] txt = new byte[31];
                    inFs.read(txt);
                    String str = new String(txt);
                    Toast.makeText(getApplicationContext(), "["+str+"]", Toast.LENGTH_SHORT).show();
                    inFs.close();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "파일 없음" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}