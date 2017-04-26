package mobile.karasoft.ma.whereiswho.util;

import java.util.HashMap;

import mobile.karasoft.ma.whereiswho.R;

/**
 * Created by yassine on 16/04/17.
 */

public class StaticRefRes {


    private HashMap<String, Integer> listOfRes;


    public static int IMG1 = R.drawable.image1;


    public static int IMG2 = R.drawable.image2;


    public static int IMG3 = R.drawable.image3;

    public StaticRefRes() {


        listOfRes = new HashMap<String, Integer>();

        listOfRes.put("1", IMG1);
        listOfRes.put("2", IMG2);
        listOfRes.put("3", IMG3);

        System.out.println("List embebed");

    }

    public HashMap<String, Integer> getListOfRes() {

        return this.listOfRes;
    }


    public int lookingForRef(String key) {

        System.out.println(key);
        return listOfRes.get(key);
    }

}
