package sample.gameplay;

import sample.gameplay.item.Item;

import java.io.Serializable;
import java.util.ArrayList;

public class Shop implements Serializable{

    private ArrayList<Item> _shop;

    public Shop(){
        _shop = new ArrayList<Item>();
        _shop.add(new Item("BlackSkin", 0));
        _shop.add(new Item("RedSkin", 5));
        _shop.add(new Item("BlueSkin", 10));
        _shop.add(new Item("YellowSkin", 15));
        _shop.add(new Item("GreenSkin", 25));
        _shop.add(new Item("GreeenSkin", 25));
        _shop.add(new Item("GreeeenSkin", 25));
        _shop.add(new Item("GreeeeenSkin", 25));

    }

    public ArrayList<Item> getShop() {
        return _shop;
    }
}
