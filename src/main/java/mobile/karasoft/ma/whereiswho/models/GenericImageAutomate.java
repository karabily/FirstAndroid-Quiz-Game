package mobile.karasoft.ma.whereiswho.models;

import java.util.HashMap;

import mobile.karasoft.ma.whereiswho.R;

/**
 * Created by yassine on 14/04/17.
 */

public class GenericImageAutomate  {



    private   static HashMap<String,String> imageMapper;




    public GenericImageAutomate() {
       imageMapper = new HashMap<String, String>();





    }
    public void addImageRessources(String a, String b){

        imageMapper.put(a,b);

    }

//
//    public int getRefImage(String value){
//
//        for(int i =0 ; i<getImageMapper().size();i++) {
//            if (value.equals(getImageMapper().get(Integer.toString(i))))
//
//                return getImageMapper().get(i);
//        }
//    }

    public HashMap<String, String> getImageMapper() {
        return imageMapper;
    }


}
