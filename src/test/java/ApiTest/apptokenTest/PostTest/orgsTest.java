package ApiTest.apptokenTest.PostTest;

import ApiTest.apptokenTest.BeforeTest.apptokenPostPrep;
import ApiTest.usertokenTest.BeforeTest.accessToken;
import ApiTest.usertokenTest.BeforeTest.userSign;
import CommonAPI.EnvInit;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requests.PostReuqests;

import java.util.HashMap;

/**
 * Created by lijing on 2018/6/5.
 */
public class orgsTest {
    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","orgs");
        return testdata;
    }

    @Test(dataProvider = "testData")
    public void orgTestPost(HashMap<String, String> data) throws Exception {
        //签名
        String sign= userSign.userSign(data);
        //获取apptoken
        String access_token= accessToken.getUsertoken();
        //发送post请求
        apptokenPostPrep.postRequestsToJson("APIurl","orgs",data,sign,access_token);
    }

}
