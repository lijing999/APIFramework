package ApiTest.apptokenTest.BeforeTest;

import CommonAPI.EnvInit;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;
import requests.GetRequests;

import java.util.HashMap;

/**
 * Created by lijing on 2018/6/1.
 * 获取apptoken
 */
public class apptoken {
    @Test
    public static void apptokenTest() throws Exception {

        HashMap<String, String> authdatas = EnvInit.getAuthData();
        System.out.println("通过Map.keySet遍历key和value：");
        for (String key : authdatas.keySet()) {
            System.out.println(key + "=" + authdatas.get(key));
        }

        JSONObject res = GetRequests.getRequests("SSOurl", "appToken", authdatas);
        String access_token = res.getString("access_token");

        System.out.println("应用token：" + access_token);

    }

    public static String getApptoken() throws Exception {

        HashMap<String, String> authdatas = EnvInit.getAuthData();
        System.out.println("通过Map.keySet遍历key和value：");
        for (String key : authdatas.keySet()) {
            System.out.println(key + "=" + authdatas.get(key));
        }

        JSONObject res = GetRequests.getRequests("SSOurl", "appToken", authdatas);
        String access_token = res.getString("access_token");

        System.out.println("应用token：" + access_token);

        return access_token;
    }

}
