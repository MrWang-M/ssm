package com.ssm.template.vo;

public class ItemVO {
    private String id;
    private String name;
    private String zan;
    private String user;

    public ItemVO() {
    }

    public ItemVO(String id, String name, String zan, String user) {
        this.id = id;
        this.name = name;
        this.zan = zan;
        this.user = user;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ItemVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", zan='" + zan + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
