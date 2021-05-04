package gcit.edu.todo_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.android.droidcafe.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDonut(View view) {
        displayToast(getString(R.string.donut_message));

    }

    public void showIceCream(View view) {
        displayToast(getString(R.string.ice_cream_message));

    }

    public void showFroYo(View view) {
        displayToast(getString(R.string.froyo_message));

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void Floating(View view) {
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        startActivity(intent);
    }
}
