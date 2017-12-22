package sample.gameplay;

import javafx.scene.paint.Color;

public  class Skins {

    private static Skins instance;


    public Skins(){
        instance = this;
    }

    public void setSkin(SnakeSkin skin, SnakeBody body){
        switch (skin){
            case Black:
                setBlackSkin(body);
                break;
            case Red:
                setRedSkin(body);
                break;
            case Blue:
                setBlueSkin(body);
                break;
            case Green:
                setGreenSkin(body);
                break;
            case Yellow:
                setYellowSkin(body);
                break;
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

    private void setBlueSkin(SnakeBody body){
        body.setFill(Color.BLUE);
    }
    private void setGreenSkin(SnakeBody body){
        body.setFill(Color.GREEN);
    }
    private void setYellowSkin(SnakeBody body){
        body.setFill(Color.YELLOW);
    }

    public static Skins getInstance(){
        if (instance == null){
            instance = new Skins();
        }
        return instance;
    }
}
