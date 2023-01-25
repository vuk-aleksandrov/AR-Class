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

        ImageButton clearButton=view.findViewById(R.id.cancel_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(ModelText_Fragment.this).commit();
            }
        });

        TextView lessonNameText=view.findViewById(R.id.lesson_name_text);
        lessonNameText.setText("Neka lekcija");

        EditText modelNameEditText=view.findViewById(R.id.model_name_edit_text);
        String modelName=modelNameEditText.getText().toString();

        EditText modelInfoSmallEditText=view.findViewById(R.id.model_info_small_edit_text);
        String modelInfoSmall=modelInfoSmallEditText.getText().toString();

        EditText modelInfoEditText=view.findViewById(R.id.model_info_edit_text);
        String modelInfo=modelInfoEditText.getText().toString();


    }
}