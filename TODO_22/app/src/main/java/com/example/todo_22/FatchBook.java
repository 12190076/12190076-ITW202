package com.example.todo_22;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.ref.WeakReference;

public class FatchBook extends AsyncTask<String, Void, String> {
    private WeakReference<TextView> mTitelText;
    private WeakReference<TextView> mAuthorText;
    FatchBook(TextView titleText, TextView authorText){

        this.mTitelText = new WeakReference<>(titleText);
        this.mAuthorText = new WeakReference<>(authorText);
    }
    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getBookInfo(strings[0]);

    }

    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject jsonObject =new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            int i = 0;
            String title = null;
            String authors= null;
            while (i < itemsArray.length()&&(authors == null && title == null)){
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                }catch (Exception e){
                    e.printStackTrace();
                }
                i++;
            }
            if (title != null && authors != null){
                mTitelText.get().setText(title);
                mAuthorText.get().setText(authors);
            }else {
                mTitelText.get().setText("No Result Found");
                mAuthorText.get().setText("");
            }
        }catch (JSONException e){
            mTitelText.get().setText("No Result Found");
            mAuthorText.get().setText("");
            e.printStackTrace();

        }
        super.onPostExecute(s);
    }

}
