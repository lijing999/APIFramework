package ApiTest.usertokenTest.PostTest;

import ApiTest.apptokenTest.AfterTest.ResAssert;
import ApiTest.usertokenTest.BeforeTest.accessToken;
import ApiTest.usertokenTest.BeforeTest.userSign;
import ApiTest.usertokenTest.BeforeTest.usertokenPostPrep;
import CommonAPI.EnvInit;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by lijing on 2018/6/6.
 */
public class setDefultOrgTest {
    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","setDefultOrg");
        return testdata;
    }

    @Test(dataProvider = "testData")
    public void setDefultOrgTestPost(HashMap<String, String> data) throws Exception {
        //签名
        String sign= userSign.userSign(data);
        //获取apptoken
        String access_token= accessToken.getUsertoken();
        //发送post请求
        JSONObject res= usertokenPostPrep.postRequestsToJson("APIurl","setDefultOrg",data,sign,access_token);
        //结果校验
        String resultcode=res.getString("result");
        System.out.println("result is " + resultcode );
        ResAssert.Result(resultcode);
    }
}
