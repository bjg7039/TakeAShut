package com.example.bjg70.example;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class recipeAdapter extends BaseAdapter{
    private ArrayList<recipe_list_data> recipeItems = new ArrayList<>();

    @Override
    public int getCount() { return recipeItems.size();}

    @Override
    public recipe_list_data getItem(int position){
        return recipeItems.get(position);
    }
    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Context context = parent.getContext();

        // recipe_row_list 레이아웃을 inflate하여 convertView 참조
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.recipe_row_list, parent, false);
        }

        // recipe_row_list에 정의한 위젯에 대한 참조
        ImageView r_img = (ImageView)convertView.findViewById(R.id.recipe_photo);
        TextView r_name = (TextView)convertView.findViewById(R.id.recipe_name);
        TextView r_explain = (TextView)convertView.findViewById(R.id.recipe_explain);
        TextView r_provability = (TextView)convertView.findViewById(R.id.recipe_provability);

        recipe_list_data recipeListData = getItem(position);

        r_img.setImageDrawable(recipeListData.getPhoto());
        r_name.setText(recipeListData.getFood_name());
        r_explain.setText(recipeListData.getFood_explain());
        r_provability.setText(recipeListData.getrecipe_provability());

        return convertView;
    }

    // 레시피 추가를 위한 함수
    public void addRecipe(Drawable photo, String name, int provability, String explain){
        recipe_list_data recipeListData = new recipe_list_data();

        recipeListData.setPhoto(photo);
        recipeListData.setFood_name(name);
        recipeListData.setRecipe_provability(provability);
        recipeListData.setFood_explain(explain);

        recipeItems.add(recipeListData);
    }
}
