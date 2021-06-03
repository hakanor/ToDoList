package com.hakanor.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        ArrayList<ExampleItem> mExampleList = (ArrayList<ExampleItem>) intent.getSerializableExtra("mExampleList");
        int position = intent.getIntExtra("position",0);
        Toast.makeText(this, mExampleList.get(position).getText1(), Toast.LENGTH_SHORT).show();


    }
}
