package com.example.arclass;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ModelText_Fragment extends Fragment {

    public ModelText_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_model_text, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView lessonNameText=view.findViewById(R.id.lesson_name_text);
        lessonNameText.setText(MyLessons.newLesson.name);

        EditText modelName = view.findViewById(R.id.model_name_edit_text);
        EditText smallInfo = view.findViewById(R.id.model_info_small_edit_text);
        EditText info      = view.findViewById(R.id.model_info_edit_text);

        ImageButton cancelButton =view.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyLessons.newLesson.newModel.name=modelName.getText().toString();
                MyLessons.newLesson.newModel.smallInfo=smallInfo.getText().toString();
                MyLessons.newLesson.newModel.info=info.getText().toString();

                getActivity().getSupportFragmentManager().beginTransaction().remove(ModelText_Fragment.this).commit();
            }
        });
    }
}