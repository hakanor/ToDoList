package com.hakanor.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {

    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<String> describes = new ArrayList<String>();

    private Button testbutton;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testbutton=findViewById(R.id.testbutton);
        recyclerView =findViewById(R.id.recylerview);

        TaskAdapter taskAdapter = new TaskAdapter(this, Task.getData());
        recyclerView.setAdapter(taskAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        testbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

    }

    public void openDialog(){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"new task");
    }

    @Override
        public void applyTexts(String title, String desc) {
        if(!title.equals("")){
            titles.add(title);
            describes.add(desc);
        }
    }


}