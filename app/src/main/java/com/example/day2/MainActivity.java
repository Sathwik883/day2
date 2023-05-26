package com.example.day2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b,b2;
    EditText ed;
    TextView tv;
    MediaPlayer mp;

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("xyx","User Online");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("xyx","User Offline");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        mp=MediaPlayer.create(this,R.raw.song);
        b2=findViewById(R.id.button2);
        tv=findViewById(R.id.textView);
        ed=findViewById(R.id.editTextTextPersonName);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alt=new AlertDialog.Builder(MainActivity.this);
                alt.setTitle("This is Title");
                alt.setMessage("This is Message");
                alt.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "ok pressed", Toast.LENGTH_SHORT).show();
                    }
                });
                alt.setNegativeButton("nope",null);
                alt.setNeutralButton("cancel",null);
                alt.show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("xyx",ed.getText().toString());
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sdm,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void setn(MenuItem item) {
        Toast.makeText(this, "Setting is clicked", Toast.LENGTH_SHORT).show();
    }

    public void dattpce(View view) {
        DatePickerDialog dp=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, year+"/"+(1+month)+"/"+dayOfMonth, Toast.LENGTH_SHORT).show();
            }
        }, 2023, 0, 6);
        dp.show();
    }

    public void timepce(View view) {
        TimePickerDialog tp=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();
            }
        }, 24, 60, true);
        tp.show();
    }

    public void str(View view) {
        mp.start();
    }

    public void pau(View view) {
        mp.pause();
    }

    public void stp(View view) {
        mp.stop();
    }
}