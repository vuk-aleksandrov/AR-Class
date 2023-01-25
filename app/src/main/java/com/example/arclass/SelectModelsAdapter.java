package com.example.arclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SelectModelsAdapter extends RecyclerView.Adapter<SelectModelsAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private final List<AR_ModelData> data;

    SelectModelsAdapter(Context context, List<AR_ModelData> data)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }


    @NonNull
    @Override
    public SelectModelsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.model_card_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectModelsAdapter.ViewHolder holder, int position) {
        AR_ModelData modelData = data.get(position);
        String ime = modelData.name;
        holder.textTitle.setText(ime);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textTitle, textDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.modelName);
            textDescription = itemView.findViewById(R.id.modelDescription);
        }
    }

}
