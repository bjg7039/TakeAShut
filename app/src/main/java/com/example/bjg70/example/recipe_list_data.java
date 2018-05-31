package com.example.bjg70.example;

import android.graphics.drawable.Drawable;

public class recipe_list_data {
    private Drawable food_photo;
    private String food_name;
    private String food_explain;
    private int recipe_provability;

    public Drawable getPhoto(){ return food_photo;}
    public void setPhoto(Drawable photo){ this.food_photo = photo;}
    public String getFood_name(){
        return food_name;
    }
    public void setFood_name(String name){this.food_name = name;}
    public String getFood_explain(){return food_explain;}
    public void setFood_explain(String explain){this.food_explain = explain;}
    public int getrecipe_provability(){return recipe_provability;}
    public void setRecipe_provability(int recipe_p){this.recipe_provability = recipe_p;}
}
