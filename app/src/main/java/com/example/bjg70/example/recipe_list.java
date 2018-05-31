package com.example.bjg70.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class recipe_list extends AppCompatActivity{
    private ListView listView; // ListView 생성
    protected int recipe_provability = 60; // 요리 레시피가 등장하는 최소 확률
    protected int recipe_count; // 레시피 갯수
    public String[][] recipe = new String[30][10];

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_list);

        listView = (ListView)findViewById(R.id.recipe_list);

        dataSetting();
    }

    // 레시피 확률을 설정
    public void setRecipe_provability(int provability){
        recipe_provability = provability;
    }


    // 레시피 메뉴의 재료 비중은 완성을 100이라 하였을때 재료별 비중 퍼센트가 정해져있다 (ex) 사과 20, 바나나40, 초콜릿 30, 식용유 10)
    // name[0]은 요리명, name[1]은 재료의 갯수 i, name[i+1]은 요리설명 그전까지는 각 재료의 종류별 이름과 퍼센테이지가 들어가있다 (ex)바나나/20)
    private String find_recipe(int i, String[] name){
        double probability = 0;
        for(int j = 1; j < i+1; j++) {
            probability += Integer.parseInt(name[j]);
        }
        if(probability > recipe_provability){
            return name[0];
        }
        else{
            return null;
        }
    }
    private void dataSetting(){
        recipeAdapter recipeAdapter = new recipeAdapter();
        set_recipe();
        for(int i = 0; i < recipe_count; i++){
            if(Integer.parseInt(recipe[i][3]) >= recipe_provability){
                recipeAdapter.addRecipe(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_menu_camera), recipe[i][1], Integer.parseInt(recipe[i][3]), recipe[i][4]);
            }
        }
        // 주어진 데이터 Adapter에 연결
        listView.setAdapter(recipeAdapter);
    }

    // 레시피 정보 설정
    public void set_recipe(){
        recipe_count = 10;
        String[][] r = {{"1000", "요리1", "재료갯수", "10","설명", "재료/확률", "재료/확률", "재료/확률", "재료/확률", "재료/확률"},
                {"1001", "요리1", "재료갯수", "20","설명", "재료/확률", "재료/확률", "재료/확률", "재료/확률", "재료/확률"},
                {"1002", "요리1", "재료갯수", "30","설명", "재료/확률", "재료/확률", "재료/확률", "재료/확률", "재료/확률"},
                {"1003", "요리1", "재료갯수", "40","설명", "재료/확률", "재료/확률", "재료/확률", "재료/확률", "재료/확률"},
                {"1004", "요리1", "재료갯수", "50","설명", "재료/확률", "재료/확률", "재료/확률", "재료/확률", "재료/확률"},
                {"1005", "요리1", "재료갯수", "60","설명", "재료/확률", "재료/확률", "재료/확률", "재료/확률", "재료/확률"},
                {"1006", "요리1", "재료갯수", "70","설명", "재료/확률", "재료/확률", "재료/확률", "재료/확률", "재료/확률"},
                {"1007", "요리1", "재료갯수", "80","설명", "재료/확률", "재료/확률", "재료/확률", "재료/확률", "재료/확률"},
                {"1008", "요리1", "재료갯수", "90","설명", "재료/확률", "재료/확률", "재료/확률", "재료/확률", "재료/확률"},
                {"1009", "요리1", "재료갯수", "100","설명", "재료/확률", "재료/확률", "재료/확률", "재료/확률", "재료/확률"}};
        recipe = r;
    }



}
