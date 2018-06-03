package com.example.issac.myapplication.MODEL.radioRows;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.issac.ppe2sanskt.R;

import java.util.List;
/*
importe : adapter
Assigne les valeurs de row ciblée
*/

public class RadioRowAdapter extends ArrayAdapter<RadioRow> {
    //tweets est la liste des models à afficher
    public RadioRowAdapter(Context context, List<RadioRow> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_radio, parent, false);
        }

        RadioRowViewHolder viewHolder = (RadioRowViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new RadioRowViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        }

        RadioRow theRow = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.name.setText(theRow.getName());
        return convertView;
    }
}

