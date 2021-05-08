package gcit.edu.todo_13;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.TODO_13.extra.MESSAGE";
    private Toolbar mainToolbar;
    private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mainToolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_orfer:
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE,mOrderMessage);
                startActivity(intent);
                return true;
            case R.id.action_Status:
                displayToast("You select status");
                return true;
            case R.id.action_favourite:
                displayToast("You select favourite");
                return true;
            case R.id.action_contact:
                displayToast("You select contact");
                return true;
            default:
                return false;

        }
    }

    public void showDonut(View view) {
        mOrderMessage = ("You ordered donut");
        displayToast(mOrderMessage);


    }

    public void showIceCream(View view) {
       mOrderMessage=(getString(R.string.ice_cream_message));
        displayToast(mOrderMessage);

    }

    public void showFroYo(View view) {
        mOrderMessage =(getString(R.string.froyo_message));
        displayToast(mOrderMessage);

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void Floating(View view) {

        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE,mOrderMessage);
        startActivity(intent);
    }
}
