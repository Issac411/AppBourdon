package com.example.issac.myapplication.MODEL.rows;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.issac.ppe2sanskt.R;

import java.util.List;

public class SimpleRowAdapter extends ArrayAdapter<SimpleRow> {
    //tweets est la liste des models à afficher
    public SimpleRowAdapter(Context context, List<SimpleRow> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_element, parent, false);
        }

        RowViewHolder viewHolder = (RowViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new RowViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.desc = (TextView) convertView.findViewById(R.id.desc);
            viewHolder.color = (ImageView) convertView.findViewById(R.id.color);
            convertView.setTag(viewHolder);
        }

        SimpleRow theRow = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.name.setText(theRow.getName());
        viewHolder.desc.setText(theRow.getDesc());
        viewHolder.color.setImageDrawable(new ColorDrawable(theRow.getColor()));

        return convertView;
    }
}
