package com.gmail.andreagarau98.beatbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Abstract class that indicates an activity that keeps a single fragment.
 * Using this abstract class allows to keep code independent from specific cases.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {
    /**
     * This app is made generic by the fact that in onCreate it generates a fragment which depends
     * on the implementation of this method.
     */
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
