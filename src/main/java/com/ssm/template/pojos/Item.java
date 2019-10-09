package com.ssm.template.pojos;

public class Item {
    private String id;
    private String name;
    private String zan;

    public Item() {
    }

    public Item(String id, String name, String zan) {
        this.id = id;
        this.name = name;
        this.zan = zan;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", zan='" + zan + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZan() {
        return zan;
    }

    public void setZan(String zan) {
        this.zan = zan;
    }
}
