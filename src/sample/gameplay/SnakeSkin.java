package sample.gameplay;

public enum SnakeSkin {
    Black, Red, Green, Blue, Yellow;



    public static SnakeSkin getSkin(String name){
        for(SnakeSkin s : SnakeSkin.values()){
            if(s.toString().equals(name)){
                return s;
            }
        }
        return null;
    }


}
