package com.example.notetoself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private boolean showDividers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button button = (Button)findViewById(R.id.button);

        pref = getSharedPreferences("Note to self", MODE_PRIVATE);
            editor = pref.edit();

            showDividers = pref.getBoolean("dividers", true);
        Switch switch1 = (Switch)findViewById(R.id.switch1);
        switch1.setChecked(showDividers);


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                showDividers = isChecked;
                editor.putBoolean("dividers", isChecked);

            }
        });

    }

    @Override
    public void onPause(){
        super.onPause();
        editor.commit();
    }

    public void OnClick(View view){
        setContentView(R.layout.activity_main);
    }
}
