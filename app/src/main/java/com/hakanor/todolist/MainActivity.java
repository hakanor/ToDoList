package com.hakanor.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {

    private CoordinatorLayout coordinatorLayout;
    private ArrayList<ExampleItem> mExampleList = new ArrayList<ExampleItem>();
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        buildRecyclerView();
        createExampleList();


                //FLOAT ACTION BUTTON //
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

    }
    public void removeItem(int position) {
        ExampleItem temp=mExampleList.get(position);
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
        showSnackbar(temp,position);
    }

    public void showSnackbar(final ExampleItem temp, final int position){
        Snackbar snackbar = Snackbar.make(coordinatorLayout,"Task done!",Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertItem(position,temp.getText1(),temp.getText2());
                        Snackbar snackbar1=Snackbar.make(coordinatorLayout,"Undo Successful :]",Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
        snackbar.show();
    }

    public void insertItem(int position,String text1,String text2) {
        mExampleList.add(position, new ExampleItem(R.drawable.check, text1, text2));
        mAdapter.notifyItemInserted(position);
    }

                        //DIALOG //
    public void openDialog(){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"Add New Task");
    }

    // --------------------------------------------------------------------//
                         //Genel //

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.check, "Line 1", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.check, "Line 3", "Line 4"));
        mExampleList.add(new ExampleItem(R.drawable.check, "Line 5", "Line 6"));
        mAdapter.setItems(mExampleList);
    }


    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mExampleList.get(position).getText1();
                mExampleList.get(position).getText2();
                mExampleList.get(position);

                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                intent.putExtra("mExampleList",mExampleList);
                intent.putExtra("position",position);
                startActivityForResult(intent, 1);
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String et1 = data.getStringExtra("editText1");
                String et2 = data.getStringExtra("editText2");
                int position=data.getIntExtra("position",0);

                        if(mExampleList.get(position).getText1().equals(et1) && mExampleList.get(position).getText2().equals(et2)){
                            //Bir değişiklik yapılmamış demektir.
                        }
                        else{
                            mExampleList.remove(position);
                            mAdapter.notifyItemRemoved(position);
                            insertItem(position,et1,et2);
                        }


            }
        }
    }

    @Override
        public void applyTexts(String title, String desc) {
        if(!title.equals("")){
            mExampleList.add(new ExampleItem(R.drawable.check, title, desc));
            mAdapter.setItems(mExampleList);
            Toast.makeText(this, "New task added.", Toast.LENGTH_SHORT).show();
        }
    }

}