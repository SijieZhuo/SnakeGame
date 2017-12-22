package sample.views.shop;

import sample.View;
import sample.views.shop.GameShop;

public class ShopView extends View {
    public ShopView(){
        super(GameShop.class.getResource("shop.fxml"));
    }
}
