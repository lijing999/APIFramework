package CommonApi;

import CommonAPI.EnvInit;
import CommonAPI.appTokenAPI;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by lijing on 2018/5/30.
 */
public class sign {


    @Test
    public void signTest() throws Exception {
        //EnvInit.setUp();
        appTokenAPI appToken=new appTokenAPI();
        //String access_token=appToken.getApptoken(EnvInit.EnvInitTest());
       // System.out.println(access_token);
    }

}
