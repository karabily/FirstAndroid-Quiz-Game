package mobile.karasoft.ma.whereiswho.models;

import android.app.Activity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import mobile.karasoft.ma.whereiswho.util.Proprieties;

/**
 * Created by yassine on 15/04/17.
 */

public class JsonUtil extends Activity{


    /*
        Load function @return String from Json File
        The idea was to auto-Generate source of Image data
     */
    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getAssets().open("dataImages.json");

            int size = is.available();

            byte[] buffer = new byte[size];


            is.read(buffer);
            System.out.println("lecture");
            is.close();
            System.out.println("Fermeture");
            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Exception");
            return null;
        }
        return json;

    }




}