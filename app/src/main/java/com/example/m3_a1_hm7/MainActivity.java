package com.example.m3_a1_hm7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IVisibleToast,IStudentAdd, Shairble {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("ololo", "MainActivity: onCreate: start MainFragment");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main_container, new MainFragment(), MainFragment.TAG);
        fragmentTransaction.commit();
    }
    @Override
    public void printToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void studentAdd(Student s) {
        MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(MainFragment.TAG);
        assert fragment != null;
        Log.d("ololo", "MainActivity: studentAdd: " + s.toString());
        fragment.studentAdd(s);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_container, fragment, MainFragment.TAG)
                .commit();
    }

    @Override
    public void shair(String s) {
        Intent intentForShare = new Intent();
        intentForShare.setAction(Intent.ACTION_SEND);
        intentForShare.setType("text/plain");
        intentForShare.putExtra(Intent.EXTRA_TEXT, s);
        if (intentForShare.resolveActivity(getPackageManager()) != null)
            startActivityForResult(intentForShare, 1);
    }
}