package sample.gameplay;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class Snake{

    ObservableList<Node> snake;
    Group snakebody;
    Node  _tail;
    int _size;
    private Skins skin;
    private SnakeSkin currentSkin;

    public ObservableList<Node> getSnake() {
        return snake;
    }

    public Group getSnakebody() {
        return snakebody;
    }

    public Snake (int x, int y, int size){
        _size = size;
        snakebody = new Group();
        snake = snakebody.getChildren();
        currentSkin = SnakeSkin.Red;

        initialize(x,y);



        System.out.println(snake.size());

    }

    public void initialize(int x, int y){
        this.addBody(x, y);
        this.addBody(x-_size, y);
        this.addBody(x - 2 * _size, y);
        this.addBody(x - 3 * _size, y);
        this.addBody(x - 4 * _size, y);

        skinUpdate();
    }


    public void addBody(double x, double y){

        SnakeBody newbody = new SnakeBody(_size);
        newbody.setSkin(currentSkin);

        newbody.setTranslateX(x);
        newbody.setTranslateY(y);
        snake.add(newbody);

    }

    public void changeDirection(Direction direction){

        _tail = snake.remove(snake.size()-1);

        switch (direction) {
            case UP:
                _tail.setTranslateX(snake.get(0).getTranslateX());
                _tail.setTranslateY(snake.get(0).getTranslateY() - _size);
                break;
            case DOWN:
                _tail.setTranslateX(snake.get(0).getTranslateX());
                _tail.setTranslateY(snake.get(0).getTranslateY()+_size);
                break;
            case LEFT:
                _tail.setTranslateX(snake.get(0).getTranslateX()-_size);
                _tail.setTranslateY(snake.get(0).getTranslateY());
                break;
            case RIGHT:
                _tail.setTranslateX(snake.get(0).getTranslateX()+_size);
                _tail.setTranslateY(snake.get(0).getTranslateY());
                break;
        }
            snake.add(0, _tail);
            skinUpdate();
    }

    public void skinUpdate(){



        for(Node n : snake){

            if(n instanceof SnakeBody){
                if(n == snake.get(0)){
                     ((SnakeBody) n).setBodyType(SnakeBodyType.Head);
                } else {
                    ((SnakeBody) n).setBodyType(SnakeBodyType.Body);
                }
                ((SnakeBody) n).setSkin(currentSkin);
            }
        }
    }

}