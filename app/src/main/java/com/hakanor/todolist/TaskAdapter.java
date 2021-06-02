package com.hakanor.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    ArrayList<Task> TaskList;
    LayoutInflater inflater;

    public TaskAdapter(Context context, ArrayList<Task> products) {
        inflater = LayoutInflater.from(context);
        this.TaskList = products;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_cardview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Task selectedTask = TaskList.get(position);
        holder.setData(selectedTask, position);

    }

    @Override
    public int getItemCount() {
        return TaskList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView taskName, taskDescription;
        ImageView checkImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            taskName = (TextView) itemView.findViewById(R.id.tw1);
            taskDescription = (TextView) itemView.findViewById(R.id.tw2);
            checkImage = (ImageView) itemView.findViewById(R.id.ImageViev);
            //checkImage.setOnClickListener(this);

        }

        public void setData(Task selectedTask, int position) {

            this.taskName.setText(selectedTask.getTaskName());
            this.taskDescription.setText(selectedTask.getTaskDescription());
            this.checkImage.setImageResource(selectedTask.getImageID());

        }


        @Override
        public void onClick(View v) {


        }

    }
}
