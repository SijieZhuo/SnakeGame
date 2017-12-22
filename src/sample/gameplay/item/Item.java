package sample.gameplay.item;

import java.io.Serializable;

public class Item implements Serializable{

    private String _name;
    private boolean _bought;
    private int _price;

    public Item(String name, int price){
        _name = name;
        _bought = false;
        _price = price;
    }


    public void hasBought(){
        _bought = true;
    }

    public int getPrice(){
        return _price;
    }

    public String getName() {
        return _name;
    }

    public boolean getBought(){
        return _bought;
    }
}
