package com.example.todo_16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class wordlistAdapter extends RecyclerView.Adapter<wordlistAdapter.WordViewHolder> {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;
    public wordlistAdapter(Context context, LinkedList<String> mWordList){
        mInflater = LayoutInflater.from(context);
        this.mWordList =mWordList;

    }
    @NonNull
    @Override
    public wordlistAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
       return new WordViewHolder(mItemView,this);
    }
    @Override
    public void onBindViewHolder(@NonNull wordlistAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }
    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView wordItemView;
        wordlistAdapter mAdapter;

        public WordViewHolder(@NonNull View itemView, wordlistAdapter mAdapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = mWordList.get(mPosition);
            mWordList.set(mPosition, "Click!" +element);
            mAdapter.notifyDataSetChanged();

        }
    }
}
