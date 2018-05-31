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

public class ListViewAdapter extends BaseAdapter{
    private ArrayList<product_list_data> listViewItemList = new ArrayList<product_list_data>();

    // listView의 항목 수를 반환해주는 메소드
    @Override
    public int getCount(){
        return listViewItemList.size();
    }

    // ListView의 항목 위치를 통해 받아오는 메소드
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.product_list, parent, false);
        }
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.product_image);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.product_name);
        TextView buyTextView = (TextView) convertView.findViewById(R.id.product_buy_date);
        TextView sellTextView = (TextView) convertView.findViewById(R.id.product_sell_by_date);

        product_list_data productListData = listViewItemList.get(position);

        iconImageView.setImageDrawable(productListData.getIcon());
        nameTextView.setText(productListData.getName());
        buyTextView.setText(productListData.getBuy_date());
        sellTextView.setText(productListData.getSell_by_date());

        return  convertView;
    }

    // ListView ID를 통해 포지션 반환
    @Override
    public long getItemId(int position){
        return position;
    }

    // ListView의 포지션으로 리스트 가져옴
    @Override
    public Object getItem(int position){
        return listViewItemList.get(position);
    }

    // 아이템을 추가시킨다
    public void addItem(Drawable icon, String name, String b_date, String S_date){
        product_list_data productListData = new product_list_data();

        productListData.setIcon(icon);
        productListData.setName(name);
        productListData.setBuy_date(b_date);
        productListData.setSell_by_date(S_date);

        listViewItemList.add(productListData);
    }

}
