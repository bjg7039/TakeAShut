package com.example.bjg70.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class pen_option extends Activity implements View.OnClickListener{
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    public EditText p_name, p_buy_date, p_sell_by_date;
    private Button create, cancel;
    public String name, buy_d, sell_d;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pen_menu);

        p_name = (EditText)findViewById(R.id.pen_name);
        p_buy_date = (EditText)findViewById(R.id.pen_buy);
        p_sell_by_date = (EditText)findViewById(R.id.pen_sell);

        set_ButtonContent();
    }

    private void set_ButtonContent(){
        create = (Button)findViewById(R.id.pen_create);
        cancel = (Button)findViewById(R.id.pen_cancel);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = p_name.getText().toString();
                buy_d = p_buy_date.getText().toString();
                databaseReference.child("product").push().setValue(name, buy_d);
                finish();
            }
        });
        cancel.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.pen_create:
                // 디비로 데이터 전송 후 product list 실행
                // 전송 값은 p_name 이 물품 이름, p_buy_date 가 구매 날짜, p_sell_by_date가 유통기한
                Intent intent = new Intent(this, product_list.class);
                startActivity(intent);
                break;
            case R.id.pen_cancel:
                this.finish();
                break;
            default:
                break;
        }
    }
}
