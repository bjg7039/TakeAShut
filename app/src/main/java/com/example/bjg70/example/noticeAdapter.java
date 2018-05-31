package com.example.bjg70.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class noticeAdapter extends BaseAdapter{
    private ArrayList<notice_list_data> noticeList = new ArrayList<>();

    @Override
    public int getCount(){ return noticeList.size(); }

    @Override
    public notice_list_data getItem(int position){ return noticeList.get(position); }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.notice_row_list, parent, false);
        }

        TextView n_number = (TextView)convertView.findViewById(R.id.notice_number);
        TextView n_title = (TextView)convertView.findViewById(R.id.notice_title);
        TextView n_date = (TextView)convertView.findViewById(R.id.notice_date);

        notice_list_data noticeListData = getItem(position);

        n_number.setText(noticeListData.getNotice_number());
        n_title.setText(noticeListData.getNotice_title());
        n_date.setText(noticeListData.getNotice_date());

        n_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        return convertView;
    }

    public void addItem(String n, String t, String d, String c) {
        notice_list_data notice_list_data = new notice_list_data();

        notice_list_data.setNotice_number(n);
        notice_list_data.setNotice_title(t);
        notice_list_data.setNotice_date(d);
        notice_list_data.setNotice_contents(c);

        noticeList.add(notice_list_data);
    }

}
