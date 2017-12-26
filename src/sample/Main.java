package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.views.main.MainView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MainView mainView = new MainView();
        Parent root = (Parent) mainView.view();
        primaryStage.setTitle("Snake Evolution");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.setWidth(605);
        primaryStage.setHeight(430);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
