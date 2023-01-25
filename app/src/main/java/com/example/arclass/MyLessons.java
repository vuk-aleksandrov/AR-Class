package com.example.arclass;

import java.util.ArrayList;

public class MyLessons {
    public static ArrayList<Lesson> lessons;
    public static Lesson newLesson;

    public static void addCreatedLesson() {
        lessons.add(newLesson);
        newLesson=null;
    }
}
