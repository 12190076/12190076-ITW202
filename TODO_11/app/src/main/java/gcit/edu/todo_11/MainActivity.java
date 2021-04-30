package gcit.edu.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView HelloTextView;
    private String[] mColorArray = {"purple_200","purple_500","purple_700","teal_200","teal_700","black",         "white","red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HelloTextView=findViewById(R.id.textView);
        // restore saved instance state (the text color)
        if (savedInstanceState != null) {
            HelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save the current text color
        outState.putInt("color", HelloTextView.getCurrentTextColor());
    }

    public void onclick(View view) {
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(28)];

        int colorResourceName = getResources().getIdentifier(colorName,
                "color", getApplicationContext().getPackageName());

        int colorRes = ContextCompat.getColor(this, colorResourceName);
        HelloTextView.setTextColor(colorRes);


    }
}