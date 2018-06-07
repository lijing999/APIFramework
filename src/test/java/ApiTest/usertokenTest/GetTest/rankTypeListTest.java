package ApiTest.usertokenTest.GetTest;

import ApiTest.apptokenTest.AfterTest.ResAssert;
import ApiTest.usertokenTest.BeforeTest.accessToken;
import ApiTest.usertokenTest.BeforeTest.userSign;
import ApiTest.usertokenTest.BeforeTest.usertokenGetPrep;
import CommonAPI.EnvInit;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by lijing on 2018/6/6.
 */
public class rankTypeListTest {
    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","rankTypeList");
        return testdata;
    }




    @Test(dataProvider = "testData")
    public void rankTypeListTest(HashMap<String, String> data) throws Exception {
        //签名
        String sign= userSign.userSign(data);
        //获取apptoken
        String access_token= accessToken.getUsertoken();
        //发送get请求
        JSONObject res= usertokenGetPrep.getRequests("APIurl","rankTypeList",data,sign,access_token);
        //结果校验
        String resultcode=res.getString("result");
        System.out.println("result is " + resultcode );
        ResAssert.Result(resultcode);

    }
}
