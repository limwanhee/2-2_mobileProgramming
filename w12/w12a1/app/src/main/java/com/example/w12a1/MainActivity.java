package com.example.w12a1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SD 메모리 사용");
        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        Button btnRead;
        final EditText edtSD;
        btnRead = (Button) findViewById(R.id.btnRead);
        edtSD = (EditText) findViewById(R.id.edtSD);
        btnRead.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileInputStream inFs = new FileInputStream( "/storage/emulated/0/LWH.txt");
                    byte[] txt = new byte[inFs.available()];
                    inFs.read(txt);
                    edtSD.setText(new String(txt));
                    btnRead.setText("과학기술인 선서");
                    inFs.close();
                }
                catch (IOException e) {
                }
            }
        });
    }
}