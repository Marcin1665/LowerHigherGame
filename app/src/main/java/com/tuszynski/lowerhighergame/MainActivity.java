package com.tuszynski.lowerhighergame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public Random RANDOM = new Random();
    private TextView msgTv;
    private EditText numberEnteredEt;
    private Button validate;
    private int numberToFind, numberTries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTv = findViewById(R.id.msg);
        numberEnteredEt = findViewById(R.id.numberEnteredEt);
        validate = findViewById(R.id.validate);
        validate.setOnClickListener(this);




        newGame();
    }

    @Override
    public void onClick(View view) {
        if (view == validate) {
            validate();
        }
    }

    private void validate() {
        int n = Integer.parseInt(numberEnteredEt.getText().toString());
        numberTries++;

        if (n == numberToFind) {
            Toast.makeText(this, "Udało ci się znaleźć liczbę " + numberToFind +
                    " w " + numberTries + " próbach",
                    Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(MainActivity.this, StartActivity.class);
            startActivity(intent2);
            newGame();
        } else if (n > numberToFind) {
            msgTv.setText(R.string.too_high);
        } else if (n < numberToFind) {
            msgTv.setText(R.string.too_low);
        }
        if (3 == numberTries){
            Toast.makeText(this, "Niestety nie udało ci się, poprawna liczba to " + numberToFind,
                    Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(MainActivity.this, StartActivity.class);
            startActivity(intent2);
            newGame();
        }
    }

    private void newGame() {
        Intent intent = getIntent();
        int A = intent.getIntExtra(StartActivity.MAX_NUMBER, 2);
        numberToFind = RANDOM.nextInt(A) + 1;
        msgTv.setText(R.string.start_msg);
        numberEnteredEt.setText("");
        numberTries = 0;
    }
}
