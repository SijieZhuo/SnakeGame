package sample.gameplay;

import sample.gameplay.item.Item;
import sample.gameplay.item.SkinItem;

import java.io.Serializable;
import java.util.ArrayList;

public class Shop implements Serializable{

    private ArrayList<Item> _shop;

    public Shop(){
        _shop = new ArrayList<Item>();
        _shop.add(new SkinItem("Black", 0));
        _shop.add(new SkinItem("Red", 5));
        _shop.add(new SkinItem("Blue", 10));
        _shop.add(new SkinItem("Green", 15));
        _shop.add(new SkinItem("Yellow", 25));
        _shop.add(new SkinItem("HuaJi", 50));
        _shop.add(new SkinItem("GrassSnake",100));

    }

    public ArrayList<Item> getShop() {
        return _shop;
    }
}
