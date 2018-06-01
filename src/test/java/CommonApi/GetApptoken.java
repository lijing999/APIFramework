package CommonApi;

import org.testng.annotations.Test;
import requests.GetRequests;
import tool.EnvPropData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by lijing on 2018/6/1.
 */
public class GetApptoken {

    @Test
    public static void getApptoken(String filename) throws IOException {
        Properties properties=EnvPropData.getProperties("E:\\AuthData.txt");
       /* String client_id= properties.getProperty("client_id");
        String client_secret= properties.getProperty("client_secret");*/

       /* HashMap<String,String> Authparam = new HashMap<String,String>();
        Authparam.put("client_id",client_id );
        Authparam.put("client_secret",client_secret );

        GetRequests.getRequests("SSOurl","",Authparam);*/

    }
}
