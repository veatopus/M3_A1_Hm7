package com.example.m3_a1_hm7;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentAddStudent extends Fragment {
    IVisibleToast iVisibleToast;
    private Student student;
    private EditText addName;
    private EditText addPhone;
    private EditText addGroup;
    private EditText addOther;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iVisibleToast = (IVisibleToast) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {

        Log.d("ololo", "FragmentAddStudent: onCreateView: start");
        View v = inflater.inflate(R.layout.fragment_add_student, container, false);
        addName = v.findViewById(R.id.addName);
        addPhone = v.findViewById(R.id.addNumberOfPhone);
        addGroup = v.findViewById(R.id.addGroup);
        addOther = v.findViewById(R.id.addOther);

        Button saveStudent = v.findViewById(R.id.saveStudent);
        saveStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentInitialisation()) {
                    MainFragment mainFragment = new MainFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(MainFragment.PUT_EXTRA, student);
                    assert getFragmentManager() != null;
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    Log.d("ololo", "FragmentAddStudent: onClick: start mainFragment");
                    mainFragment.setArguments(bundle);
                    ft.replace(R.id.activity_main_container, mainFragment);
                    ft.commit();
                } else {
                    iVisibleToast.printToast("не все поля заполнены");
                }
            }
        });

        return v;
    }

    private boolean studentInitialisation() {
        if ((!addGroup.getText().toString().equals("")) && (!addName.getText().toString().equals("")) && (!addPhone.getText().toString().equals(""))) {
            Log.d("ololo", "studentInitialisation: ");
            student = new Student(addName.getText().toString(), addPhone.getText().toString(), addGroup.getText().toString());
            if (!("".contentEquals(addOther.getText()))) {
                student.setNote(addOther.getText().toString());
            }
            return true;
        } else {
            return false;
        }
    }
}