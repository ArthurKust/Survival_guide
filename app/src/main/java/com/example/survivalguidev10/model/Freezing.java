package com.example.survivalguidev10.model;

public class Freezing {
    // поля сущности
    private String name; // поле названия
    private String tipDescription; // поле описания
    private int tipResource; // поле ресурса


    public Freezing(String name, String tipDescription, int tipResource) {
        this.name = name;
        this.tipDescription = tipDescription;
        this.tipResource = tipResource;
    }

    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipDescription() {
        return tipDescription;
    }

    public void setTipDescription(String tipDescription) {
        this.tipDescription = tipDescription;
    }

    public int getTipResource() {
        return tipResource;
    }

    public void setTipResource(int tipResource) {
        this.tipResource = tipResource;
    }

}
