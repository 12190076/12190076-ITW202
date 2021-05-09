package gcit.edu.todo_14_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void Alert(View view) {
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
        myAlertBuilder.setTitle("Alert");
        myAlertBuilder.setMessage("Click Ok to continue, or Cancel to Stop:");
        myAlertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Pressed Ok",
                        Toast.LENGTH_SHORT).show();
            }
        });

        myAlertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Pressed Cancel", Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.show();
    }

    public void next(View view) {
        Intent intent = new Intent(this,Todo_14_3.class);
        startActivity(intent);
    }

}