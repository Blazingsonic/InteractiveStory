package com.saier.sebastian.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.saier.sebastian.interactivestory.R;


public class MainActivity extends ActionBarActivity {

    private EditText mNameField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameField = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameField.getText().toString();
                // Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show(); // This refers to the anonymous inner class itself, not the Activity
                startStory(name);
            }
        });
    }

    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class); // Just a method, not an object, therefore we can use 'this'
        intent.putExtra(getString(R.string.key_name), name);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText("");
    }
}

