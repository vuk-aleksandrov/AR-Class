package com.example.arclass;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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

        holder.playLessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AR_Lesson_Activity.class);
                intent.putExtra("LEKCIJA", position);
                view.getContext().startActivity(intent);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(view.getContext(), MainActivity2.class);
                intent.putExtra("name", klasa);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);*/

                if(holder.someText.getVisibility() == View.VISIBLE)
                {
                    holder.someText.setVisibility(View.GONE);
                    holder.playLessonButton.setVisibility(View.GONE);
                    holder.card.getLayoutParams().height = 400;
                    holder.card2.getLayoutParams().height = 400;
                    holder.card.requestLayout();
                    holder.card2.requestLayout();
                }
                else
                {
                    holder.playLessonButton.setVisibility(View.VISIBLE);
                    holder.someText.setVisibility(View.VISIBLE);
                    holder.card.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    holder.card2.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    holder.card2.requestLayout();
                    holder.card.requestLayout();
                }


                Toast.makeText(view.getContext(), ime, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView lessonName, lessonDescription, someText;
        CardView card, card2;

        Button playLessonButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card2 = itemView.findViewById(R.id.cardViewId2);
            card = itemView.findViewById(R.id.cardViewId);
            someText = itemView.findViewById(R.id.someHiddenText);
            playLessonButton = itemView.findViewById(R.id.playLessonButton);
            lessonName = itemView.findViewById(R.id.presentationName);
            lessonDescription = itemView.findViewById(R.id.presentationDescription);

        }
    }
}
