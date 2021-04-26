package com.example.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditext, mLodcationEdittext, mShareTextEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditext= findViewById(R.id.website_edittext);
        mLodcationEdittext=findViewById(R.id.location_edittext);
        mShareTextEditText=findViewById(R.id.share_edittext);
    }

    public void openwebsite(View view) {
        String url=mWebsiteEditext.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntent","Cant handle this intent");
        }
    }

    public void openlocation(View view) {
        String loc= mLodcationEdittext.getText().toString();
        Uri addressUri=Uri.parse("geo:0,0?q="+ loc);
        Intent intent= new Intent(Intent.ACTION_VIEW,addressUri);
        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntent","Cant handle this intent");
        }

    }

    public void shareText(View view) {
        String text =mShareTextEditText.getText().toString();
        String mimeType="text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share This Text With;")
                .setText(text)
                .startChooser();
    }

    public void click(View view) {
        Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntents","Cant handle this intent");
        }
    }
}