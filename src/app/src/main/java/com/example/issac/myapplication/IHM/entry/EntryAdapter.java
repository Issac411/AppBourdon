package com.example.issac.myapplication.IHM.entry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.issac.myapplication.MODEL.Commercial;
import com.example.issac.myapplication.MODEL.Company;
import com.example.issac.myapplication.MODEL.Entry;
import com.example.issac.myapplication.MODEL.rows.EntryViewHolder;
import com.example.issac.ppe2sanskt.R;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class EntryAdapter extends ArrayAdapter<Entry> {

    int layoutId;

    public EntryAdapter(Context context, int layoutId, List<Entry> data){
        super(context,layoutId,data);
        this.layoutId = layoutId;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(layoutId,parent,false);
        }


        EntryViewHolder viewHolder = (EntryViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new EntryViewHolder();
            viewHolder.txtCompanyName = (TextView) convertView.findViewById(R.id.txtCompanyName);
            viewHolder.txtStatus = (TextView) convertView.findViewById(R.id.txtStatus);
            viewHolder.txtDateTime = (TextView) convertView.findViewById(R.id.txtDateTime);
            viewHolder.txtCommercial = (TextView) convertView.findViewById(R.id.txtCommercial);
            convertView.setTag(viewHolder);
        }

        Entry entry = getItem(position);
        Company uneCompany = entry.getCompany();
        Commercial unCommercial = entry.getCommercial();



        viewHolder.txtCompanyName.setText(uneCompany.getName());
        viewHolder.txtStatus.setText(entry.getStatus());
        viewHolder.txtDateTime.setText(entry.getDate().toString());
        viewHolder.txtCommercial.setText(unCommercial.getNickName()+ " " + unCommercial.getName());

        return convertView;
    }


}
