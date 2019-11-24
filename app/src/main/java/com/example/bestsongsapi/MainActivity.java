package com.example.bestsongsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static  Button updatebtn;
    public static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updatebtn = findViewById(R.id.updatebtn);
        data= findViewById(R.id.apiData);

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiBackend process = new ApiBackend();
                process.execute();
            }
        });
    }

}
