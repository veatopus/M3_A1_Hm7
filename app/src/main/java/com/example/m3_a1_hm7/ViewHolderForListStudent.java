package com.example.m3_a1_hm7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.m3_a1_hm7.R;
import com.example.m3_a1_hm7.Student;

public class ViewHolderForListStudent extends RecyclerView.ViewHolder {
    private TextView fullName;
    private TextView phoneNumber;
    private TextView group;
    private Student student;
    private ImageView icon;

    public ViewHolderForListStudent(@NonNull View itemView) {
        super(itemView);
        initialization(itemView);
        // TODO: setOnclickListner

    }


    private void initialization(View itemView) {
        fullName = itemView.findViewById(R.id.vh_student_full_name);
        phoneNumber = itemView.findViewById(R.id.vh_student_phone_number);
        group = itemView.findViewById(R.id.vh_student_group);
        ImageView icon = itemView.findViewById(R.id.vh_student_icon_of_student);
    }

    void onBind(@NonNull Student student){
        putStudentInXmlFile(student);
    }

    private void putStudentInXmlFile(@NonNull Student student){
        fullName.setText(student.getName());
        phoneNumber.setText(student.getNumberPhone());
        group.setText(student.getGroup());
    }
}