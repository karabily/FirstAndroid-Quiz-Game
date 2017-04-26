package mobile.karasoft.ma.whereiswho.models.singleton;

import mobile.karasoft.ma.whereiswho.models.bean.User;

/**
 * Created by yassine on 21/04/17.
 */

public class UserInstance {

    private static UserInstance INSTANCE = null;


    static User user ;

    private UserInstance() {


    }

    public static UserInstance getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new UserInstance();
            user = new User("test");
        }
    }
}
