package com.example.m3_a1_hm7;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Objects;

public class MainFragment extends Fragment implements IStudentAdd {
    private IVisibleToast iVisibleToast;
    private AdapterForListStudent adapter = new AdapterForListStudent();
    static final String PUT_EXTRA = "143";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iVisibleToast = (IVisibleToast) context;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        Bundle bundle = getArguments();
        //Log.d("ololo", "onCreateView: " + bundle);
        if (bundle != null) {
            Log.d("ololo", "MainFragment: onCreateView: start adapter for add student");
            adapter.add((Student) (Objects.requireNonNull(bundle.getSerializable(PUT_EXTRA))));
        }

        Log.d("ololo", "MainFragment: onCreateView: start");
        adapter = new AdapterForListStudent();
        RecyclerView recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        Button buttonAdd = v.findViewById(R.id.mainFragment_buttonAdd);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Log.d("ololo", "MainFragment: onClick: start FragmentAddStudent");
                ft.replace(R.id.activity_main_container, new FragmentAddStudent());
                ft.commit();
            }
        });
        return v;
    }

    @Override
    public void studentAdd(Student s) {
        adapter.add(s);
    }
}