package ApiTest.apptokenTest.GetTest;

import ApiTest.apptokenTest.AfterTest.ResAssert;
import ApiTest.apptokenTest.BeforeTest.appSign;
import ApiTest.apptokenTest.BeforeTest.apptoken;
import CommonAPI.EnvInit;
import com.alibaba.fastjson.JSONObject;
import demo.apptokenGetPrep;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by lijing on 2018/6/7.
 */
public class userRolesTest {
    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","userRoles");
        return testdata;
    }


    @Test(dataProvider = "testData")
    public void userRolesTest(HashMap<String, String> data) throws Exception {
        for (String key : data.keySet()) {
            System.out.println("key= "+ key + " and value= " + data.get(key));
        }
        //签名
        String sign= appSign.getSign(data);
        //获取apptoken
        String access_token= apptoken.getApptoken();
        //发送get请求
        JSONObject res= apptokenGetPrep.getRequests("APIurl","userRoles",data,sign,access_token);

        //结果校验
        String resultcode=res.getString("result");
        System.out.println("result is " + resultcode );
        ResAssert.Result(resultcode);
    }
}
