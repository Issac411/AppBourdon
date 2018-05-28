package com.example.issac.ppe2sanskt.MODEL.rows;

public class SimpleRow {
    private int color;
    private String name;
    private String desc;

    public SimpleRow(int color, String name, String desc) {
        this.color = color;
        this.name = name;
        this.desc = desc;
    }


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
