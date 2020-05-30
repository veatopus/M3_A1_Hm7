package com.example.m3_a1_hm7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IVisibleToast {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("ololo", "MainActivity: onCreate: start MainFragment");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.activity_main_container, new MainFragment());
        fragmentTransaction.commit();
    }
    @Override
    public void printToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
