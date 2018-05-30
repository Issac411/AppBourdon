package com.example.issac.myapplication.MODEL.radioRows;

import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.ToggleButton;

public class RadioRow {
    private String name;
    private ToggleButton radio;

    public RadioRow(String name, ToggleButton Button) {
        this.name = name;
        this.radio = Button;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ToggleButton getRadio() {
        return radio;
    }

    public void setRadio(ToggleButton radio) {
        this.radio = radio;
    }
}
