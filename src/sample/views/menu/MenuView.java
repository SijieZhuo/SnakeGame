package sample.views.menu;

import sample.View;
import sample.views.menu.MainMenu;


public class MenuView extends View {
    public MenuView(){
        super(MainMenu.class.getResource("mainMenu.fxml"));
    }
}
