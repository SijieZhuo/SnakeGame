package sample.gameplay.item;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import sample.gameplay.GameData;
import sample.gameplay.ItemType;
import sample.gameplay.SnakeSkin;
import sample.views.menu.MainMenu;
import sample.views.shop.GameShop;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemPane extends VBox implements Initializable {

    Item item;
    GameData data;

    @FXML
    Rectangle rec;
    @FXML
    Button button;
    @FXML
    Text text;

    public void setup(Item item, GameData gameData){
        this.item = item;
        this.data = gameData;
        text.setText(item.getName());
        if(item.getBought()){
            if(data.getCurrentSkin().toString().equals(item.getName())){
                button.setText("Current");
            }else {
                button.setText("Change");
            }
        } else {
            button.setText(item.getPrice() + "");
        }
    }

    @FXML
    public void buttonHit() {
        if (item.getBought()) {
            if(item instanceof SkinItem) {
                data.setCurrentSkin(SnakeSkin.getSkin(item.getName()));
                GameShop.getInstance().setup(data);
            } else {

            }

        } else {
            if(data.getScore()<item.getPrice()){
                return;
            }
            data.useScore(item.getPrice());
            button.setText("Change");
            item.hasBought();

        }
        data.save();
        MainMenu.getInstance().updateScore();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
