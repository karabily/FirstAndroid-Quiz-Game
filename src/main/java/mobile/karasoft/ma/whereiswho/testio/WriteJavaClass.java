package mobile.karasoft.ma.whereiswho.testio;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import mobile.karasoft.ma.whereiswho.R;

/**
 * Created by yassine on 19/04/17.
 */

public class WriteJavaClass extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        String fileName = "StaticRefRes.java";
        String content = "hello world";

        FileOutputStream outputStream = null;
        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }



    public String loadJSONFromAsset() {
        String json = null;
        try {
            System.out.println("ouverture du fichier json");
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
