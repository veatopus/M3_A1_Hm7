package com.example.m3_a1_hm7;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class AdapterForListStudent extends RecyclerView.Adapter<ViewHolderForListStudent>{
    private ArrayList<Student> data = new ArrayList<>();

    void add(@NonNull Student student){
        Log.d("ololo", "AdapterForListStudent: add: add student \n" + student.toString());
        Log.d("ololo", "AdapterForListStudent: add: data size = " + data.size());
        student.setId(data.size());
        data.add(student);
        Collections.sort(data);
        Log.d("ololo", "AdapterForListStudent: add: data size = " + data.size());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderForListStudent onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolderForListStudent(inflater.inflate(R.layout.item_view_holder_for_list_student, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForListStudent holder, int position) {
        holder.onBind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    String getInfo() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            s.append(data.get(i).toString()).append("\n");
        }
        return s.toString();
    }
}