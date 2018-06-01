package CommonApi.ExcelVersion;

import CommonAPI.EnvInit;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requests.GetRequests;

import java.io.IOException;
import java.util.*;

/**
 * Created by lijing on 2018/5/30.
 * 用excle获取接口参数和接口请求拼接
 *
 */
public class appToken {
    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","apptoken");
        return testdata;
    }
    @Test(dataProvider = "testData")
    public void appTokenTest(HashMap<String, String> data) throws Exception {

        GetRequests.getRequests("SSOurl","appToken",data);
    }



    //获取 apptoken 的接口，可调用
    public static String appToken(HashMap<String, String> data) throws IOException {
        JSONObject res=GetRequests.getRequests("SSOurl","appToken",data);
        String access_token=res.getString("access_token");
        return access_token;
    }

}
