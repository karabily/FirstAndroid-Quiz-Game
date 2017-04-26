package mobile.karasoft.ma.whereiswho.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;

import mobile.karasoft.ma.whereiswho.R;
import mobile.karasoft.ma.whereiswho.models.ClassBuilder;
import mobile.karasoft.ma.whereiswho.models.DataAreaClick;
import mobile.karasoft.ma.whereiswho.models.GenericImageAutomate;
import mobile.karasoft.ma.whereiswho.util.Proprieties;
import mobile.karasoft.ma.whereiswho.util.StaticRefRes;

public class FirstScreenGame extends AppCompatActivity {

    static int counter = 0;

    TextView mTextField;

    TextView questionField;




    CountDownTimer countDownTimer;
    HashMap<String, String> sortedData = new HashMap<String, String>();
    HashMap<String, String> mapOfRef;
    GenericImageAutomate list = new GenericImageAutomate();
    String attribute = "";


    StaticRefRes ref = new StaticRefRes();


    private int res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen_game);

        String value = getIntent().getStringExtra("keyOfNextImage");

        //  int parsed = Integer.parseInt(data);
        System.out.println(value);
        // First, we declare the XML res for our activity


        //--Personalisable solution of the area click
        DataAreaClick test = new DataAreaClick();

        //- this class is used to let Zoom -/+ works
        ContextImageView imgView = new ContextImageView(this, test);

        //- set the image ressource for the game
        System.out.println("value passed  " + value);

//        int k = Integer.parseInt(value);

        imgView.setImageResource(ref.lookingForRef(value));


        System.out.println("counter  " + counter);
        // to delete after finish testing
        System.out.println("Json test  " + loadJSONFromAsset());
        String json = loadJSONFromAsset();

/*        try {
            JSONObject jObj = new JSONObject(json);
            JSONArray jArr = jObj.getJSONArray("tab");
            String[] allData = new String[jArr.length()];
            for (int i = 0; i < jArr.length() - 1; i++) {

                JSONObject jobject = jArr.getJSONObject(i);
                String key = jobject.getString("key");
                String ref = jobject.getString("ref");
                //  list.addImageRessources(key,ref);
                allData[i] = ref;
                sortedData.put(key, ref);
               // System.out.println("Data sorted : " + key + "  " + ref);


            }

            String temp = "";

            for (int i = 0; i < allData.length - 1; i++) {
                if (i == 0) {
                    temp = "public static int image" + i + "=" + allData[0] + " ";
                    System.out.println(allData[i]);
                }

                attribute = temp + "public static int image" + i + "=" + allData[i] + " ";


            }

            System.out.println(attribute);
            //serializeAddressJDK7(attribute);
            writeToFile(attribute, this);
            System.out.println("serialisaion");
        } catch (JSONException e) {
            e.printStackTrace();
        }*/


        if (counter == 0) {

        }


        // ViewGroup is used to deliver more flexibility
        // to show multiple Object on one activity
        // layout 'll reference our layout

        final ViewGroup layout = (ViewGroup) findViewById(R.id.test);


        // Given proprieties to our official view

        imgView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));

        // Add into layout our image game

        layout.addView(imgView);


        mTextField = (TextView) findViewById(R.id.counter);


        countDownTimer = new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                mTextField.setText("Ready for next activity");
                System.out.println(" counter " + counter);
                counter++;
                String a = String.valueOf(counter);
               /* System.out.println(" key hashmap " + a);
                System.out.println(" value hashmap " + list.getImageMapper().get(a));
                String val = list.getImageMapper().get(a);
                System.out.println("counter  :" + counter + "  " + val);*/
                Intent intent = new Intent(FirstScreenGame.this, FirstScreenGame.class);

                switch (String.valueOf(counter)) {
                    case "1":
                        intent.putExtra("keyOfNextImage", "2");
                        break;
                    case "2":
                        intent.putExtra("keyOfNextImage", "3");
                        break;
                    case "3":
                        intent.putExtra("keyOfNextImage", "4");
                        break;
                }


                finish();
                // System.out.println("before destruction of activity");


                // System.out.println("Activity  normaly is finished");
                Toast toast = Toast.makeText(layout.getContext(), "YESS", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
                startActivity(intent);
                finish();
            }

        }.start();


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countDownTimer.cancel();


    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
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

    public void serializeAddressJDK7(String data) {


/*        try {
            System.out.println("Creation of file");
            //Proprieties.SORTEDCLASS.createNewFile(); // if file already exists will do nothing
        } catch (IOException e) {
            System.out.println(e.getCause());
            System.out.println("Excepetion Occured on serial");
        }*/


        // FileOutputStream oFile =getAssets().
        //new FileOutputStream(new File(getFilesDir()+"//StaticRefRes.java"), false);


/*
        Writer out = new OutputStreamWriter(oFile, "UTF8");
        out.write(Proprieties.HEADOFCLASSFILE+" "+data+" "+Proprieties.ENDOFCLASSFILE);
        out.close();*/
        String FILENAME = "StaticRefRes.java";
        String string = "hello world!";

        FileOutputStream fos = null;
        try {
            System.out.println("ouverture java file ");
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Exc 1 FNF");
        }

        try {
            //  System.out.println("Exc 2 ioExce   ");
            fos.write(string.getBytes());
            fos.close();
            System.out.println("Yasss");
        } catch (IOException e) {
            System.out.println(e.getMessage() + "Yasss");
            System.out.println("Exc 2 ioExce   ");
        }


    }

    private void writeToFile(String data, Context context) {
        //Gson g =

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
