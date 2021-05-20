package com.example.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private ArrayList<sport> mSportsData;
    private sportAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSportsData = new ArrayList<>();
        mAdapter = new sportAdapter(this,mSportsData);
        mRecyclerView.setAdapter(mAdapter);
        initializedData();

    }

    private void initializedData() {
        String[] sportsList = getResources().getStringArray(R.array.sports_tittles);
        String[] sportInf= getResources().getStringArray(R.array.sports_info);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sport_images);

        mSportsData.clear();

        for (int i=0;i<sportsList.length;i++){
            mSportsData.add(new sport(sportsList[i],sportInf[i],sportsImageResources.getResourceId(i, 0)));

        }
        mAdapter.notifyDataSetChanged();
        //sportsImageResources.recycle();
    }
}