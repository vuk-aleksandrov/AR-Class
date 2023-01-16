package com.example.arclass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ModelPlace_BottomSheetDialog extends BottomSheetDialogFragment {

    Uri fileURI;

    public ModelPlace_BottomSheetDialog()
    {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.model_place_bottom_sheet_dialog, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button1 = view.findViewById(R.id.choose_model_from_device_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onGoToStorageClicked();
                dismiss();
            }
        });

        Button button2 = view.findViewById(R.id.choose_model_from_database_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onGoToDatabaseClicked();
                dismiss();
            }
        });
    }

    private BottomSheetListener listener;

    public interface BottomSheetListener {
        void onGoToStorageClicked();
        void onGoToDatabaseClicked();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        listener=(BottomSheetListener) context;
    }
}
