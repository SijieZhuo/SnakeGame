package sample.views.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import sample.gameplay.*;
import sample.views.menu.MainMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class Game extends AnchorPane implements Initializable {

    public static final int SIZE = 20;
    public static final int APP_W = SIZE * 25;
    public static final int APP_H = SIZE * 15;

    private Scene scene;
    private Snake snake;
    private Direction direction = Direction.RIGHT;
    private Food foodObj;
    private Node food;
    private double speed;
    private boolean hasEdge;
    private Timeline timeline;
    private boolean hasChanged = true;
    private GameData gameData;
    private int score;
    private

    @FXML
    AnchorPane pane;

    private void timeAction(){

        timeline = new Timeline();

        KeyFrame frame = new KeyFrame(Duration.seconds(speed), event -> {

            snake.changeDirection(direction);
            collisionDetact();
            hasChanged = true;
        });

        timeline.getKeyFrames().addAll(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);

    }

    private void keyAction(){

        scene = pane.getScene();
        scene.setOnKeyPressed(event ->  {

            if (!hasChanged){
                return;
            }

            switch(event.getCode()){
                case W:
                    if (direction != Direction.DOWN) {
                        direction = Direction.UP;
                    }
                    break;
                case A:
                    if (direction != Direction.RIGHT) {
                        direction = Direction.LEFT;
                    }
                    break;
                case S:
                    if (direction != Direction.UP) {
                        direction = Direction.DOWN;
                    }
                    break;
                case D:
                    if (direction != Direction.LEFT) {
                        direction = Direction.RIGHT;
                    }
                    break;
            }
            hasChanged = false;
        });
    }

    public void setup(GameLevel level, boolean hasEdge, GameData data){

        gameData = data;
        score = 0;

        if(level.equals(GameLevel.Easy)){
            speed = 0.2;
        }else if (level.equals(GameLevel.Median)){
            speed = 0.1;
        } else{
            speed = 0.05;
        }

        this.hasEdge = hasEdge;

        keyAction();
        timeAction();

        food = resetFood().getFood();
        pane.getChildren().addAll(snake.getSnakebody(), food);

    }

    private boolean mapWithEdge(){
        boolean collide = false;
        Node head = snake.getSnake().get(0);
        if (head.getTranslateX()>APP_W
                || head.getTranslateX()<0
                || head.getTranslateY()>APP_H
                || head.getTranslateY()<0){
            collide = true;
        }
        return collide;
    }

    private boolean mapNoEdge(){
        Node head = snake.getSnake().get(0);

        if(head.getTranslateX() < 0) // to the left screen
            head.setTranslateX(APP_W-SIZE);
        if(head.getTranslateX() >= APP_W) // right screen
            head.setTranslateX(0.0);
        if(head.getTranslateY() < 0) //top screen
            head.setTranslateY(APP_H-SIZE);
        if(head.getTranslateY() >= APP_H) //down screen
            head.setTranslateY(0.0);
        return false;
    }

    private void collisionDetact(){
        boolean collide = false;
        Node head = snake.getSnake().get(0);

        if(hasEdge){
            collide = mapWithEdge();
        }else{
            collide = mapNoEdge();
        }

        for (Node n : snake.getSnake()){
            if( n.getTranslateX() == head.getTranslateX() && n.getTranslateY() == head.getTranslateY() && n != head ){
                collide = true;
            }
        }

        if(collide){
            gameOver();
        }

        if(head.getTranslateX() == foodObj.getPos().getX()
                && head.getTranslateY() == foodObj.getPos().getY()){
            pane.getChildren().remove(food);
            food = resetFood().getFood();
            pane.getChildren().add(food);
            Node tail = snake.getSnake().get(snake.getSnake().size()-1);
            snake.addBody(tail.getTranslateX(),tail.getTranslateY());

            score ++;
            gameData.increaseScore(1);
            gameData.save();
            MainMenu.getInstance().updateScore();
        }
    }

    private void gameOver(){
        snake.getSnake().clear();
        snake.initialize(5 * SIZE, 5 * SIZE);
        direction = Direction.RIGHT;
        System.out.println(score);
        score = 0;
    }

    public void play(){

        timeline.play();

    }

    private Food resetFood(){

        boolean valid = false;
        while (!valid){
            valid = true;
            foodObj.generetePos();
            Point2D pos = foodObj.getPos();
            for (Node n : snake.getSnake()) {
                if (n.getTranslateX() == pos.getX() && n.getTranslateY() == pos.getY()) {
                    valid = false;
                }
            }

        }
        return foodObj;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        snake = new Snake(5 * SIZE, 5 * SIZE, SIZE);
        foodObj = new Food(APP_W, APP_H, SIZE);
        this.setMaxSize(APP_W,APP_H);
        //snake.setSkin(SnakeSkin).


    }
}
