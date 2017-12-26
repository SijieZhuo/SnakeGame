package sample.gameplay;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public  class Skins {

    private static Skins instance;
    private final String imagePath = "sample/imageSource/";


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
            case Test:
                setTestSkin(body);
                break;
            case HuaJi:
                setHuaJiSkin(body);
                break;
            case GreenReal:
                setGreenRealSnake(body);
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

    private void setTestSkin(SnakeBody body){
        Image image = new Image(imagePath + "head1.png");
        body.setFill(new ImagePattern(image));
        if (body.getDirection().equals(Direction.UP)){
            body.setRotate(180);
        } else if (body.getDirection().equals(Direction.LEFT)){
            body.setRotate(90);
        } else if (body.getDirection().equals(Direction.RIGHT)){
            body.setRotate(270);
        }else {
            body.setRotate(0);
        }
    }

    private void setGreenRealSnake(SnakeBody body){
        Image Snakehead = new Image(imagePath+ "greenSnake/head.png");
        Image Snakebody = new Image(imagePath+ "greenSnake/body.png");
        Image Snaketail = new Image(imagePath+ "greenSnake/tail.png");

        if(body.getType().equals(SnakeBodyType.Head)){
            body.setFill(new ImagePattern(Snakehead));
        } else if (body.getType().equals(SnakeBodyType.Body)){
            body.setFill(new ImagePattern(Snakebody));
        }else {
            body.setFill(new ImagePattern(Snaketail));
        }

        if (body.getDirection().equals(Direction.UP)){
            body.setRotate(180);
        } else if (body.getDirection().equals(Direction.LEFT)){
            body.setRotate(90);
        } else if (body.getDirection().equals(Direction.RIGHT)){
            body.setRotate(270);
        }else {
            body.setRotate(0);
        }


    }

    private void setHuaJiSkin(SnakeBody body){
    Image image = new Image(imagePath + "HuaJi.png");
    body.setFill(new ImagePattern(image));
}

    public static Skins getInstance(){
        if (instance == null){
            instance = new Skins();
        }
        return instance;
    }
}
