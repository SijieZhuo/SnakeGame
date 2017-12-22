package sample.views.game;

import sample.View;
import sample.views.game.Game;

public class GameView extends View {
    public GameView() {
        super(Game.class.getResource("game.fxml"));
    }
}
