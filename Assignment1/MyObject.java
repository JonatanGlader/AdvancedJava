package com.company;

public class MyObject {

    private String name;
    private int number;
    private boolean bool;

    public MyObject(String name, int number, boolean bool) {
        this.name = name;
        this.number = number;
        this.bool = bool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public String toString() {
        return this.name + ", " + this.number + ", " + this.bool;
    }
}
