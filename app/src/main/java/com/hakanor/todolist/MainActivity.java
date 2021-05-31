package com.hakanor.todolist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {

    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<String> describes = new ArrayList<String>();

    private Button testbutton;
    private ListView listView;
    public ArrayAdapter<String> itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testbutton=findViewById(R.id.testbutton);
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles);
        listView=findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);

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
        itemsAdapter.notifyDataSetChanged();
    }


}