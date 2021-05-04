package gcit.edu.todo_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        textView = (TextView) findViewById(R.id.textView1);
        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.setText(msg);

        Spinner spinner = findViewById(R.id.spinner2);
        if (spinner != null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.labels_arrray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner !=null){
            spinner.setAdapter(adapter);
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radioButton:
                if (checked)
                    displayToast(getString(R.string.same_day));
                break;
            case R.id.radioButton2:
                    if (checked)
                        displayToast(getString(R.string.next_day));
                    break;
            case R.id.radioButton3:
                if (checked)
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                break;
        }
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String message = parent.getItemAtPosition(position).toString();
        displayToast(message);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}