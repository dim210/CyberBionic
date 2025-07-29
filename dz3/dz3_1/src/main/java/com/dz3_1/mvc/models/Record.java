package com.dz3_1.mvc.models;

import lombok.Data;

@Data
//@NoArgsConstructor
public class Record {
    private int id;
    private String text;

 /*   public Record() {}
    public Record(int id, String text) {}

    public int getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return "Record(id=" + this.getId() + ", text=" + this.getText() + ")";
    }*/
}
