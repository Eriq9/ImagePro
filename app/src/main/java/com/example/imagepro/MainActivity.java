package com.example.imagepro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {
    static {
        if(OpenCVLoader.initDebug()){
            Log.d("MainActivity: ","Opencv is loaded");
        }
        else {
            Log.d("MainActivity: ","Opencv failed to load");
        }
    }

    Button RealTimeData;
    Button Stored;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RealTimeData=findViewById(R.id.btnRealTime);
        Stored = (Button)findViewById(R.id.btnStored);

        RealTimeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CameraActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });


        Stored.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent StoredIntent = new Intent (MainActivity.this, StoredActivity.class);

                startActivityForResult(StoredIntent, 101);

            }
        });

    }
}