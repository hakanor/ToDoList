package com.hakanor.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {
    @NonNull

    private EditText edittext1;
    private EditText edittext2;
    private ExampleDialogListener listener;

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.layout_dialog,null);
        builder.setView(v);
        builder.setTitle("Add New Task");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = edittext1.getText().toString();
                String desc = edittext2.getText().toString();
                listener.applyTexts(title,desc);
                if(title.equals("")){
                    Toast.makeText(getContext(),"The task could not be added because title is blank.",Toast.LENGTH_LONG).show();
                }
            }
        });

        edittext1 = v.findViewById(R.id.edit_title);
        edittext2 = v.findViewById(R.id.edit_desc);

        // Enter tusuna basıldığı zaman RecyclerView'e eleman ekliyor.
        edittext2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    String title = edittext1.getText().toString();
                    String desc = edittext2.getText().toString();
                    listener.applyTexts(title,desc);
                    if(title.equals("")){
                        Toast.makeText(getContext(),"The task could not be added because title is blank.",Toast.LENGTH_LONG).show();
                    }
                    dismiss();
                }
                return false;
            }
        });
        //

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must ");
        }
    }

    public interface ExampleDialogListener{
        void applyTexts(String title,String desc);
    }
}
