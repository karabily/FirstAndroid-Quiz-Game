package mobile.karasoft.ma.whereiswho.models;

import java.util.ArrayList;

/**
 * Created by yassine on 13/04/17.
 */

public class DataAreaClick {
    private ArrayList<Integer> listOfCoord ;
    private int size;

    public DataAreaClick() {
        this.listOfCoord = new ArrayList();
    }

    public void addElements(int... e){
        for(int i =0;i<e.length;i++) {

            listOfCoord.add(e[i]);

        }
    }
    public ArrayList getListOfCoord(){


        return this.listOfCoord;
    }
}
