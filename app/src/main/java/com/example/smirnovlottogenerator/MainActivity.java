package com.example.smirnovlottogenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumber;
    private EditText secondNumber;
    private Button generateNumbers;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        generateNumbers = findViewById(R.id.numberGenerator);
        result = findViewById(R.id.result);

        generateNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (firstNumber.getText().toString().equals("") | secondNumber.getText().toString().equals("")) {
                        String errorText = "Please enter number!";
                        errorMessage(errorText);
                    } else {
                        int numOne = Integer.parseInt(firstNumber.getText().toString());
                        int numTwo = Integer.parseInt((secondNumber.getText().toString()));
                        String randomNumbers = generateNum(numOne, numTwo);
                        result.setText(randomNumbers);
                    }
                } catch (NumberFormatException ignored){

                }
            }
        });
    }
    private void errorMessage(String errorText){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, errorText, duration);
        toast.show();
    }

    private String generateNum(int numOne, int numTwo){
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= numTwo; i++){
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        ArrayList<Integer> selectedNumbers = new ArrayList<>();
        for (int i = 0; i < numOne; i++){
            selectedNumbers.add(numberList.get(i));
        }
        Collections.sort(selectedNumbers);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : selectedNumbers){
            stringBuilder.append(String.valueOf(i));
            stringBuilder.append(", ");
        }
        return stringBuilder.toString().replaceAll(", $", "");
    }
}