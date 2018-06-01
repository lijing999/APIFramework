package ToolTest;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requests.GetRequests;
import tool.MultiData;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by lijing on 2018/6/1.
 */
public class MultiDataTest {

    @DataProvider
    public Object[][] providerMethod(Method method) throws Exception {
        if(method.getName().contains("Token")){
            return MultiData.Ssodata();
        }
        else {
            return MultiData.Apidata("orgs");
        }
    }

    @Test(dataProvider="providerMethod")
    public void AToken(HashMap<String, String> data) throws IOException {

    }

    @Test(dataProvider="providerMethod")
    public void Api(HashMap<String, String> data) throws IOException {
        JSONObject res= GetRequests.getRequests("SSOurl","appToken",data);
        String access_token=res.getString("access_token");
        System.out.println(access_token);
    }
}
