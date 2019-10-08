package com.ssm.template.pojos;

public class Item {
    private String id;
    private String name;

    public Item() {
    }

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
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
}
