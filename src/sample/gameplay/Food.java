package sample.gameplay;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.util.Random;

public class Food{

    int _xPos, _yPos;

    int _width, _height;

    int _size;

    Random randomNumber;

    public Food(int x, int y, int size){
        randomNumber = new Random();
        _width = x;
        _height = y;
        _size = size;

    }

    public void generetePos(){
        _xPos = randomNumber.nextInt(_width/_size-1);
        _yPos = randomNumber.nextInt(_height/_size-1);
    }

    public Point2D getPos(){
        return new Point2D(_xPos*_size,_yPos*_size);
    }

    public Node getFood(){
        Rectangle food = new Rectangle(_xPos*_size,_yPos*_size, _size, _size);
        food.setFill(Color.RED);
        return food;
    }


}
