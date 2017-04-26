package mobile.karasoft.ma.whereiswho.models.bean;

/**
 * Created by yassine on 20/04/17.
 */

public class User {


    private String name;
    private Score score;


    public User(String name) {
        this.name = name;
        this.score = new Score();

    }


    public String getName(){
        return this.name;
    }

    public void iWin(){

        
    }








}
