package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private double inputValue;
    private double firstArg = 0;
    private double secondArg;
    private String left = "";
    private String right;
    private StringBuilder inputStr = new StringBuilder();
    private TextView resultsTV;
    private TextView workingsTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultsTV = findViewById(R.id.resultsTV);
        workingsTV = findViewById(R.id.workingsTV);
    }

    public void numberClick(View view) {
        String buttonValue = ((Button) view).getText().toString();
        inputStr.append(buttonValue);
        inputValue = Integer.parseInt(inputStr.toString());
        workingsTV.setText(left + inputStr);
        //resultsTV.setText(String.valueOf(inputValue));
    }

    public void clickPlus(View view) {
        firstArg = firstArg + inputValue;
        inputValue = 0;
        left = inputStr.append("+").toString();
        inputStr.setLength(0);
        resultsTV.setText(String.valueOf(firstArg));

    }

    public void clickMinus(View view) {
    }

    public void clickMultiply(View view) {
    }

    public void clickDivide(View view) {
    }

    public void operatorClick(View view) {
        String operatorValue = ((Button) view).getText().toString();
        Toast.makeText(this, operatorValue,Toast.LENGTH_SHORT).show();
        resultsTV.setText(String.valueOf(inputValue));
    }

    public void equalsClick(View view) {
    }

    public void deleteClick(View view) {
        inputStr.setLength(inputStr.length() -1);
        workingsTV.setText(inputStr);
    }

    public void clearClick(View view) {
        left = "";
        inputValue = 0;
        firstArg = 0;
        inputStr.setLength(0);
        workingsTV.setText(inputStr);
        resultsTV.setText(inputStr);
    }
}