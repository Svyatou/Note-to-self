package com.example.notetoself;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class DialogNewNote extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.dialog_new_note, null);


        final EditText editTitle = (EditText)dialogView.findViewById(R.id.editTitle);
        final EditText editDescription = (EditText)dialogView.findViewById(R.id.editDescription);
        final CheckBox checkBoxIdea = (CheckBox)dialogView.findViewById(R.id.checkBoxIdea);
        final CheckBox checkBoxToDo = (CheckBox)dialogView.findViewById(R.id.checkBoxTodo);
        final Button btnCanel = (Button)dialogView.findViewById(R.id.btnCancel);
        final Button btnOk = (Button)dialogView.findViewById(R.id.btnOk);
        final CheckBox checkBoxImportant = (CheckBox)dialogView.findViewById(R.id.checkBoxImportant);

        builder.setView(dialogView).setMessage("Add a new note");
        btnCanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Note newNote = new Note();
                newNote.setTitle(editTitle.getText().toString());
                newNote.setDescription(editDescription.getText().toString());
                newNote.setIdea(checkBoxIdea.isChecked());
                newNote.setTodo(checkBoxToDo.isChecked());
                newNote.setImportant(checkBoxImportant.isChecked());

                MainActivity callingActivity = (MainActivity)getActivity();
                callingActivity.createNewNote(newNote);

                dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note newNote = new Note();
                newNote.setTitle(editTitle.getText().toString());
                newNote.setDescription(editDescription.getText().toString());
                newNote.setIdea(checkBoxIdea.isChecked());
                newNote.setImportant(checkBoxImportant.isChecked());
                newNote.setTodo(checkBoxToDo.isChecked());

                MainActivity callingActivity = (MainActivity) getActivity();
                callingActivity.createNewNote(newNote);
                dismiss();
            }
        });
        return builder.create();
    }
}
