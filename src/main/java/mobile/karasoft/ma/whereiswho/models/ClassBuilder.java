package mobile.karasoft.ma.whereiswho.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;

import mobile.karasoft.ma.whereiswho.util.Proprieties;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by yassine on 16/04/17.
 */

public class ClassBuilder {





    public static void main(String args[]) throws IOException {

       HashMap<String,String> sortedData = new HashMap<String,String>();
        String attribute ="";

        //System.out.println(JsonUtil.loadJSONFromAsset());

        ClassBuilder obj = new ClassBuilder();

        String data = "package mobile.karasoft.ma.whereiswho.util; public class StaticRefRes{public static int x=0;}";


        JsonUtil a = new JsonUtil();
        String json = a.loadJSONFromAsset();
        System.out.println(json);
        try {

            Thread.sleep(5000);


            JSONObject jObj = new JSONObject(json);
            JSONArray jArr = jObj.getJSONArray("GenericImageAutomate");
            String[] allData = new String[jArr.length()];
            for (int i = 0; i < jArr.length(); i++) {

                JSONObject jobject = jArr.getJSONObject(i);
                String key = jobject.getString("key");
                String ref = jobject.getString("ref");
              //  list.addImageRessources(key,ref);
                allData[i] = ref;
                sortedData.put(key,ref);
                System.out.println("Data sorted : " + key + "  " + ref);


            }

            String temp="" ;

            for (int i = 0; i < allData.length; i++) {
                    if(i==0){
                        temp ="public static int image"+i+"="+allData[0] +" ";
                    }

                    attribute = temp + "public static int image"+i+"="+allData[i] + " ";


            }

            System.out.println(attribute);
            obj.serializeAddressJDK7(attribute);




        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }


    public static void serializeAddressJDK7(String data) throws IOException {


        try {
            System.out.println("Creation of file");
            Proprieties.SORTEDCLASS.createNewFile(); // if file already exists will do nothing
        } catch (IOException e) {
            System.out.println(e.getCause());
            System.out.println("Excepetion Occured on serial");
        }
        FileOutputStream oFile = new FileOutputStream(new File("StaticRefRes.java"), false);



        Writer out = new OutputStreamWriter(oFile, "UTF8");
        out.write(Proprieties.HEADOFCLASSFILE+" "+data+" "+Proprieties.ENDOFCLASSFILE);
        out.close();


    }

}


