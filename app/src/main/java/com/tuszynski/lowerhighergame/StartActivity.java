package com.tuszynski.lowerhighergame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    private TextView startView;
    private EditText rangeNumber;
    private Button start;
    public static final String MAX_NUMBER = "com.tuszynski.application.lowerhighergame.MAX_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        start = findViewById(R.id.goToNextActivity);
        rangeNumber = findViewById(R.id.range);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                moveToGameActivity();
            }
        });
    }

    private void moveToGameActivity() {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);

        int oneUseVariable = Integer.parseInt(rangeNumber.getText().toString());
        intent.putExtra(MAX_NUMBER,oneUseVariable);
        startActivity(intent);
    }

}