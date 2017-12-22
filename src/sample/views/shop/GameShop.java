package sample.views.shop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import sample.gameplay.GameData;
import sample.gameplay.Shop;
import sample.gameplay.item.Item;
import sample.gameplay.item.ItemPane;
import sample.gameplay.item.ItemView;
import sample.views.main.MainApp;
import sample.views.menu.MainMenu;
import sample.views.menu.MenuView;

import java.net.URL;
import java.util.ResourceBundle;

public class GameShop implements Initializable {



    private Shop shop;
    private GameData gameData;

    @FXML
    ScrollPane scrollPane;

    @FXML
    HBox hBox;

    @FXML
    Button back;

    public void setup(GameData data){
        gameData = data;
        shop = gameData.getShop();

        for (Item i : shop.getShop()){
            ItemView view = new ItemView();
            hBox.getChildren().add(view.view());
            ItemPane itemPane = (ItemPane) view.controller();
            itemPane.setup(i,gameData);
        }
    }

    public void backHit(){
        MenuView menuView = new MenuView();
        MainApp.getInstance().changeCentre(menuView);
        MainMenu menu = (MainMenu) menuView.controller();
        menu.setup(gameData);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
