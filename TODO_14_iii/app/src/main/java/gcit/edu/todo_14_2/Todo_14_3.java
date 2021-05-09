package gcit.edu.todo_14_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Todo_14_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_14_3);
    }

    public void date(View view) {
        DialogFragment newFragment = new date_pickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    public void processDatePickerResult(int year, int month, int dayOfMonth){
        String month_string = Integer.toString(month+1);
        String year_string = Integer.toString(year);
        String day_string = Integer.toString(dayOfMonth);

        String date_message =(month_string + "/"+ day_string +"/"+year_string);

        Toast.makeText(this, "Date:" +date_message, Toast.LENGTH_SHORT).show();
    }
}
