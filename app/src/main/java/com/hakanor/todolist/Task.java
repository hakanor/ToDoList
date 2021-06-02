package com.hakanor.todolist;

import java.util.ArrayList;

public class Task {
    private int imageID;
    private String taskName;
    private String taskDescription;

    public Task(){

    }

    public Task(int imageResource, String text1, String text2) {
        imageID = imageResource;
        taskName = text1;
        taskDescription = text2;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String productName) {
        this.taskName = productName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String productDescription) {
        this.taskDescription = productDescription;
    }

    public static ArrayList<Task> getData() {
        ArrayList<Task> productList = new ArrayList<Task>();
        int checkImage = R.drawable.check;
        String[] productNames = {"Ekmek Al", "Su al", "Pazara git","Su iç"};

        for (int i = 0; i < 4; i++) {
            Task temp = new Task();
            temp.setImageID(checkImage);
            temp.setTaskName(productNames[i]);
            temp.setTaskDescription("Açıklama ");
            productList.add(temp);

        }

        return productList;

    }
}
