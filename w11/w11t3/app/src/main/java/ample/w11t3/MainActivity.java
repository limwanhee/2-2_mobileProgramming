package ample.w11t3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btnRead;
    EditText edtRaw; //final 붙었는데 수정을 안할꺼기에 지움

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnRead = (Button) findViewById(R.id.btnRead);
        edtRaw = (EditText) findViewById(R.id.edtRaw);
        btnRead.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    InputStream inputS = getResources().openRawResource(R.raw.raw_data);
                    byte[ ] txt = new byte[inputS.available()];
                    inputS.read(txt);
                    edtRaw.setText(new String(txt));
                    inputS.close();
                }
                catch (IOException e) {

                }
            }
        });
    }
}
