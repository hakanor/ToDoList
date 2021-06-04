package com.hakanor.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NewActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        ArrayList<ExampleItem> mExampleList = (ArrayList<ExampleItem>) intent.getSerializableExtra("mExampleList");
        int position = intent.getIntExtra("position",0);
        Toast.makeText(this, mExampleList.get(position).getText1(), Toast.LENGTH_SHORT).show();

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText1.setText(mExampleList.get(position).getText1());
        editText2.setText(mExampleList.get(position).getText2());
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setEnabled(true);
                editText2.setEnabled(true);
            }
        });

    }
}
