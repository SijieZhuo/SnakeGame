package sample.views.main;

import sample.View;
import sample.views.main.MainApp;

public class MainView extends View {

    public MainView(){
        super(MainApp.class.getResource("mainApp.fxml"));
    }
}
