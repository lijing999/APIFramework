package ApiTest.usertokenTest.BeforeTest;

import CommonAPI.EnvInit;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;
import requests.PostReuqests;

import java.util.HashMap;

/**
 * Created by lijing on 2018/6/4.
 */
public class accessToken {

    @Test
    public void accesstokenTest() throws Exception {
        //获取参数列表（不依赖于其他接口的参数）
        HashMap<String, String> AccesstokenParams=EnvInit.getAccesstokenParams();
        // 从authroize接口响应中获取的code参数添加到参数列表中
        String code=authorize.getCode();
        AccesstokenParams.put("code",code);
        for (String key : AccesstokenParams.keySet()) {
            System.out.println("key= "+ key + " and value= " + AccesstokenParams.get(key));
        }
        JSONObject resbody=PostReuqests.postRequestsToJson("SSOurl","accessToken",AccesstokenParams);
        String access_token=resbody.getString("access_token");
        System.out.println("access_token=" +access_token );

    }

    public static String getUsertoken() throws Exception {
        //获取参数列表（不依赖于其他接口的参数）
        HashMap<String, String> AccesstokenParams=EnvInit.getAccesstokenParams();
        // 从authroize接口响应中获取的code参数添加到参数列表中
        String code=authorize.getCode();
        AccesstokenParams.put("code",code);
        JSONObject resbody=PostReuqests.postRequestsToJson("SSOurl","accessToken",AccesstokenParams);
        String access_token=resbody.getString("access_token");
        System.out.println("access_token=" +access_token );

        return access_token;

    }
}
