package com.example.issac.myapplication.MODEL.radioRows;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.ToggleButton;

public class RadioRow {
    private String name;

    public RadioRow(String name, Boolean isChecked) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
