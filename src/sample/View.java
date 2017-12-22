package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;

public class View {
    private FXMLLoader _loader;

    public View (URL viewURL){
        _loader = new FXMLLoader(viewURL);
    }

    public Node view(){
        try{
            return _loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public Object controller(){
        return _loader.getController();
    }
}
