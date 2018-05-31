package com.example.bjg70.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView danger_text, caution_text, safety_text;
    private ImageView imageView1, imageView2;
    private ImageView today_photo;

    // 생성될 떄 초기 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int danger = 0, caution = 0, safety = 0;

        Intent intent = getIntent();
        for(int i=10; i<10; i++){
            String data = intent.getStringExtra("sell_by_date");
            if(count_day(data) < 4){
                danger++;
            }
            else if (count_day(data) < 8){
                caution++;
            }
            else{
                safety++;
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        danger_text = (TextView)findViewById(R.id.danger_product);
        danger_text.setText("● 위험 : " + danger + "개");

        caution_text = (TextView)findViewById(R.id.caution_product);
        caution_text.setText("● 경고 : " + caution + "개");

        safety_text = (TextView)findViewById(R.id.safety_product);
        safety_text.setText("● 안전 : " + safety + "개");

        imageView1 = (ImageView)findViewById(R.id.camera_icon);
        imageView2 = (ImageView)findViewById(R.id.pen_icon);

        imageView1.setImageResource(R.drawable.camera);
        imageView2.setImageResource(R.drawable.pen);

        today_photo = (ImageView)findViewById(R.id.today_recipe);

        today_photo.setImageResource(R.drawable.todaymenu);
    }
    public int count_day(String date){
        String s_month, s_day;
        int month, day;
        int index;
        Calendar today = Calendar.getInstance();
        Calendar product_date = Calendar.getInstance();

        index = date.indexOf("/");
        s_month = date.substring(0, index);
        s_day= date.substring(index + 1);
        month = Integer.parseInt(s_month);
        day = Integer.parseInt(s_day);
        product_date.set(2018, month, day);

        long t = today.getTimeInMillis()/86400000;
        long d = product_date.getTimeInMillis()/86400000;
        long count = t - d;

        return (int)count;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.all_product) {
            Intent intent = new Intent(MainActivity.this, product_list.class);
            startActivity(intent);
        } else if (id == R.id.today_menu) {
            Intent intent = new Intent(MainActivity.this, recipe_list.class);
            startActivity(intent);
        } else if (id == R.id.menu_notice) {
            Intent intent = new Intent(MainActivity.this, notice_list.class);
            startActivity(intent);
        } else if (id == R.id.camera_recognition) {
            Intent intent = new Intent(MainActivity.this, camera_option.class);
            startActivity(intent);
        } else if (id == R.id.write_recognition) {
            Intent intent = new Intent(MainActivity.this, pen_option.class);
            startActivity(intent);
        } else if(id == R.id.setting){
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
        } //else if 로그아웃 기능

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
