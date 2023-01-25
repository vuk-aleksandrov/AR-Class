package com.example.arclass;

import java.util.ArrayList;

public class Lesson {
    public String name, info;
    public ArrayList<AR_ModelData> models;
    public AR_ModelData newModel;

    public void addCreatedModel() {
        newModel.name="shit";
        models.add(newModel);
        // newModel=null;
    }
}
