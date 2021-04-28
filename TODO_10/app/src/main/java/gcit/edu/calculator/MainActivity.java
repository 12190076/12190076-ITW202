package gcit.edu.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mresult;
    private calculator mcaculator;
    private EditText mTextviewfirst,mTextviewsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mresult=findViewById(R.id.ressult);
        mTextviewfirst=findViewById(R.id.editText1);
        mTextviewsecond=findViewById(R.id.editText2);

        mcaculator=new calculator();

    }
    public void compute(calculator.operator operator){
        String operandone=mTextviewfirst.getText().toString();
        String operandtwo=mTextviewsecond.getText().toString();
        String result="";
        switch (operator){
            case ADD:
               result= String.valueOf(mcaculator.add(Double.valueOf(operandone), Double.valueOf(operandtwo)));
               break;
            case SUB:
                result= String.valueOf(mcaculator.sub(Double.valueOf(operandone), Double.valueOf(operandtwo)));
                break;
            case MUL:
                result= String.valueOf(mcaculator.mul(Double.valueOf(operandone), Double.valueOf(operandtwo)));
                break;
            case DIV:
                result= String.valueOf(mcaculator.div(Double.valueOf(operandone), Double.valueOf(operandtwo)));
                break;
            default:
                Log.d("Invalid operator","can't handle");
                break;
        }
        mresult.setText(result);
    }


    public void add(View view) {compute(calculator.operator.ADD);

    }

    public void sub(View view) {compute(calculator.operator.SUB);
    }

    public void mul(View view) {compute(calculator.operator.MUL);
    }

    public void div(View view) {compute(calculator.operator.DIV);
    }
}