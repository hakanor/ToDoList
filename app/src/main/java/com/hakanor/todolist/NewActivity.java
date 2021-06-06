package com.hakanor.todolist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NewActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private ImageView edit_button;
    private ImageView check_button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        ArrayList<ExampleItem> mExampleList = (ArrayList<ExampleItem>) intent.getSerializableExtra("mExampleList");
        final int position = intent.getIntExtra("position",0);
        Toast.makeText(this, mExampleList.get(position).getText1(), Toast.LENGTH_SHORT).show();
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText1.setBackgroundResource(android.R.drawable.editbox_background);
        editText2.setBackgroundResource(android.R.drawable.editbox_background);
        editText1.setText(mExampleList.get(position).getText1());
        editText2.setText(mExampleList.get(position).getText2());
        edit_button=findViewById(R.id.edit_button);
        check_button=findViewById(R.id.check_button);

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setEnabled(true);

                editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        editText1.post(new Runnable() {
                            @Override
                            public void run() {
                                InputMethodManager inputMethodManager= (InputMethodManager) NewActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                                inputMethodManager.showSoftInput(editText1, InputMethodManager.SHOW_IMPLICIT);
                            }
                        });
                    }
                });
                editText1.requestFocus();

                editText2.setEnabled(true);
                check_button.setVisibility(View.VISIBLE);
            }
        });

        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("editText1", editText1.getText().toString());
                intent.putExtra("editText2", editText2.getText().toString());
                intent.putExtra("position", position);
                setResult(RESULT_OK, intent);
                finish();

            }
        });


    }
}
