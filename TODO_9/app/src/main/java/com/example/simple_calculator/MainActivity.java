package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mOperandOneEditText;
    private EditText mOperandTwoEditText;
    private TextView mResultTextView;

    private calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOperandOneEditText=findViewById(R.id.edit_1);
        mOperandTwoEditText=findViewById(R.id.edit_2);
        mResultTextView=findViewById(R.id.result);

        mCalculator = new calculator();



    }
    private void compute(calculator.Operator operator) {
        String operandOne=mOperandOneEditText.getText().toString();
        String operandTwo=mOperandTwoEditText.getText().toString();
        String result = "";
        switch (operator) {
            case ADD:
                result=String.valueOf(mCalculator.add(Double.valueOf(operandOne),Double.valueOf(operandTwo)));
                break;
            case SUB:
                result =String.valueOf(mCalculator.sub(Double.valueOf(operandOne),Double.valueOf(operandTwo)));
                break;
            case DIV:
                result = String.valueOf(mCalculator.div(Double.valueOf(operandOne),Double.valueOf(operandTwo)));
                break;
            case MUL:
                result = String.valueOf(mCalculator.mul(Double.valueOf(operandOne),Double.valueOf(operandTwo)));
                break;
            default:
                Log.d("invalid", "Can't handdle");
                break;
        }
        mResultTextView.setText(result);
    }

    public void onAdd(View view) {
        compute(calculator.Operator.ADD);
    }

    public void onSub(View view) {
        compute(calculator.Operator.SUB);
    }

    public void onDiv(View view) {
        compute(calculator.Operator.DIV);
    }

    public void onMul(View view) {
        compute(calculator.Operator.MUL);
    }
}