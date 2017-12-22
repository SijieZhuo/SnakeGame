package sample.gameplay;

import sample.Main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class GameData implements Serializable {

    private int score;
    private Shop shop;
    private SnakeSkin currentSkin;

    public GameData(){
    score = 100;
    shop = new Shop();
    shop.getShop().get(0).hasBought();
    currentSkin = SnakeSkin.Black;
    }

    public int getScore(){
        return score;
    }

    public SnakeSkin getCurrentSkin() {
        return currentSkin;
    }

    public void setCurrentSkin(SnakeSkin currentSkin) {
        this.currentSkin = currentSkin;
    }

    public Shop getShop() {
        return shop;
    }

    public void useScore(int price){
        score = score - price;
    }

    public void increaseScore(int amount){
        score = score + amount;
    }

    public void save() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("gameData"));
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
