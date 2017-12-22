package sample.views.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import sample.View;
import sample.gameplay.GameData;
import sample.views.menu.MainMenu;
import sample.views.menu.MenuView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class MainApp implements Initializable {


    private static MainApp instance;
    private GameData gameData;

    @FXML
    Button start;

    @FXML
    BorderPane pane;

    @FXML
    public void startHit(){
//        GameView gameView = new GameView();
//        pane.setCenter(gameView.view());
//        Game game = (Game)gameView.controller();
//        game.setup(GameLevel.Hard,false);
//        game.play();

        MenuView menuView = new MenuView();
        pane.setCenter(menuView.view());
        MainMenu menu = (MainMenu) menuView.controller();
        menu.setup(gameData);
    }

    public static MainApp getInstance (){
        return instance;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;

        File dir = new File("gameData");

        if (dir.exists()){
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(
                        new FileInputStream("gameData"));
                gameData = (GameData) objectInputStream.readObject();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            gameData = new GameData();
        }
        gameData.save();
    }

    public void changeCentre(View view){
        pane.setCenter(view.view());
    }
}
