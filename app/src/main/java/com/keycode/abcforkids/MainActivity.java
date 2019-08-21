package com.keycode.abcforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnPronouce;
    private Button btnPair;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        btnPronouce = findViewById(R.id.btnPronouce);
        btnPronouce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, PronounceActivity.class);
                startActivity(intent);
            }
        });

        btnPair = findViewById(R.id.btnPair);
        btnPair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, PairLetterActivity.class);
                startActivity(intent);
            }
        });
    }
}
