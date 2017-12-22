package sample.gameplay;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public  class Skins {

    private static Skins instance;
    private Snake snake;
    SnakeSkin snakeSkin;

    public Skins(){
        instance = this;
    }

    public void setSkin(SnakeSkin skin, SnakeBody body){
        if(skin.equals(SnakeSkin.Red)){
            setRedSkin(body);
        }
    }

    private void setRedSkin(SnakeBody body){
        if(body.getType().equals(SnakeBodyType.Head)){
            body.setFill(Color.BLACK);
            System.out.println("HEad");
        }else{
            body.setFill(Color.RED);
            System.out.println("notHEad");
        }
    }

    public static Skins getInstance(){
        if (instance == null){
            instance = new Skins();
        }
        return instance;
    }
}
