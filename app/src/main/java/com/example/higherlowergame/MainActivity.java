package com.example.higherlowergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    int randomNumber;

    public void generateRandomNumber(){
        randomNumber = random.nextInt(20);
    }

    public void onClick(View view){
        int guessedNumber;

        TextView textView = (TextView) findViewById(R.id.textField);
        if(textView.getText().toString().isEmpty()){
            Toast.makeText(this, "Empty Field! Enter number.", Toast.LENGTH_SHORT).show();
        }else {
            guessedNumber = Integer.parseInt(textView.getText().toString());

            if(randomNumber < guessedNumber){
                Toast.makeText(this, "Go lower.", Toast.LENGTH_SHORT).show();
            }else if(randomNumber > guessedNumber){
                Toast.makeText(this, "Go Higher.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "You got it right! Try again.", Toast.LENGTH_SHORT).show();
                generateRandomNumber();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
    }
}
