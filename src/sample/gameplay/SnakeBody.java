package sample.gameplay;

import javafx.scene.shape.Rectangle;

public class SnakeBody extends Rectangle {

    private SnakeSkin snakeSkin;

    private SnakeBodyType type;

    private Direction direction;

    public SnakeBody(int size){
        this.setWidth(size);
        this.setHeight(size);
        type = SnakeBodyType.Body;
        direction = Direction.RIGHT;
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

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
