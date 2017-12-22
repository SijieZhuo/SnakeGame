package sample.gameplay;

import javafx.scene.shape.Rectangle;

public class SnakeBody extends Rectangle {

    private SnakeSkin snakeSkin;

    private SnakeBodyType type;

    public SnakeBody(int size){
        this.setWidth(size);
        this.setHeight(size);
        type = SnakeBodyType.Body;
    }


    public void setSkin(SnakeSkin skin){
        snakeSkin = skin;
        Skins.getInstance().setSkin(skin, this);
    }

    public void setBodyType(SnakeBodyType type){
        this.type = type;
    }

    public SnakeBodyType getType() {
        return type;
    }
}
