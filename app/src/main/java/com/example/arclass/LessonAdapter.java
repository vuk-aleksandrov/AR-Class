package com.example.arclass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private final List<Lesson> data;

    LessonAdapter(Context context, List<Lesson> data)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }


    @NonNull
    @Override
    public LessonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.lesson_card_content, parent, false);
        return new LessonAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonAdapter.ViewHolder holder, int position) {

        Lesson lessonData = data.get(position);
        String ime = lessonData.name;
        holder.lessonName.setText(ime);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView lessonName, lessonDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lessonName = itemView.findViewById(R.id.presentationName);
            lessonDescription = itemView.findViewById(R.id.presentationDescription);

        }
    }
}
