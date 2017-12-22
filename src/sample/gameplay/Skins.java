package sample.gameplay;

import javafx.scene.paint.Color;

public  class Skins {

    private static Skins instance;


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
            body.setFill(Color.RED);
        }else{
            body.setFill(Color.web("#ff6060"));
        }
    }

    private void setBlackSkin(SnakeBody body){
        body.setFill(Color.BLACK);
    }

    public static Skins getInstance(){
        if (instance == null){
            instance = new Skins();
        }
        return instance;
    }
}
