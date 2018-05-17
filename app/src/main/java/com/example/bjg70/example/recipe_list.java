package com.example.bjg70.example;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class recipe_list extends AppCompatActivity{
    private ListView listView; // ListView 생성

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_list);

        listView = (ListView)findViewById(R.id.recipe_list);

        dataSetting();
    }

    // 주어진 데이터를 설정하는 함수
    private void dataSetting(){
        recipeAdapter recipeAdapter = new recipeAdapter();

        // 반복을 통해 임시 데이터 저장
        for(int i = 0; i < 10; i++){
            recipeAdapter.addRecipe(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_menu_gallery), "요리 제목", "요리설명");
        }

        // 주어진 데이터 Adapter에 연결
        listView.setAdapter(recipeAdapter);
    }
}
