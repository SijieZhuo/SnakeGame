package sample.views.menu;

import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import sample.gameplay.GameData;
import sample.gameplay.GameLevel;
import sample.views.game.Game;
import sample.views.game.GameView;
import sample.views.shop.GameShop;
import sample.views.shop.ShopView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu implements Initializable {

    private static MainMenu instance;
    private GameData gameData;
    private GameLevel level;
    private  boolean hasEdge;
    private IntegerProperty scoreProperty;

    @FXML
    BorderPane pane = new BorderPane();
    @FXML
    Text score;
    @FXML
    ToggleButton speed1, speed2, speed3;
    @FXML
    ToggleButton edge, noEdge;
    @FXML
    Button shop, setting, play;

    ToggleGroup speedGroup = new ToggleGroup();
    ToggleGroup edgeGroup = new ToggleGroup();

    public void setup(GameData data){
        gameData = data;
        level = GameLevel.Easy;
        hasEdge = true;

        updateScore();

        speedGroupSetting();
        edgeGroupSetting();


    }


    public void updateScore(){
        score.setText("Score : " + gameData.getScore());
    }

    private void speedGroupSetting(){

        speedGroup.getToggles().addAll(speed1,speed2,speed3);
        speed1.setSelected(true);
        speed1.setDisable(true);

        speedGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println(speedGroup.getSelectedToggle().getUserData().toString());
            if(speedGroup.getSelectedToggle().equals(speed1)){
                level = GameLevel.Easy;
                speed1.setDisable(true);
                speed2.setDisable(false);
                speed3.setDisable(false);
            } else if(speedGroup.getSelectedToggle().equals(speed2)){
                level = GameLevel.Median;
                speed1.setDisable(false);
                speed2.setDisable(true);
                speed3.setDisable(false);
            } else{
                level = GameLevel.Hard;
                speed1.setDisable(false);
                speed2.setDisable(false);
                speed3.setDisable(true);
            }
        });
    }

    private void edgeGroupSetting(){

        edgeGroup.getToggles().addAll(edge, noEdge);
        edge.setSelected(true);
        edge.setDisable(true);

        edgeGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println(speedGroup.getSelectedToggle().getUserData().toString());
            if(edgeGroup.getSelectedToggle().equals(edge)){
                hasEdge = true;
                edge.setDisable(true);
                noEdge.setDisable(false);
            } else{
                hasEdge = false;
                edge.setDisable(false);
                noEdge.setDisable(true);
            }
        });
    }

    @FXML
    public void playHit(){

        GameView gameView = new GameView();
        pane.setCenter(gameView.view());

        Game game = (Game)gameView.controller();
        game.setup(level,hasEdge,gameData);
        game.play();
    }

    @FXML
    public void shopHit(){

//        ShopView shopView= new ShopView();
//        MainApp.getInstance().changeCentre(shopView);
//        GameShop shop = (GameShop)shopView.controller();
//        shop.setup(gameData);

        ShopView shopView = new ShopView();
        pane.setCenter(shopView.view());

        GameShop shop = (GameShop)shopView.controller();
        shop.setup(gameData);
    }

    public static MainMenu getInstance(){
        return instance;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
    }
}
