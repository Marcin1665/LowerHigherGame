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

    private static Intent intent;
    public static final Random RANDOM = new Random();
    private TextView msgTv;
    private EditText numberEnteredEt;
    private Button validate;
    private int numberToFind, numberTries;
    public static final int A = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTv = (TextView) findViewById(R.id.msg);
        numberEnteredEt = (EditText) findViewById(R.id.numberEnteredEt);
        validate = (Button) findViewById(R.id.validate);
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
            Toast.makeText(this, "Udało ci się znaleźć liczbę " + numberToFind + "!" +
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
        numberToFind = RANDOM.nextInt(A) + 1;
        msgTv.setText(R.string.start_msg);
        numberEnteredEt.setText("");
        numberTries = 0;
    }
}
