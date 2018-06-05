package ApiTest.usertokenTest.GetTest;

import ApiTest.usertokenTest.BeforeTest.accessToken;
import ApiTest.usertokenTest.BeforeTest.userSign;
import ApiTest.usertokenTest.BeforeTest.usertokenGetPrep;
import CommonAPI.EnvInit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
    public void userApiPrepTest(HashMap<String, String> data) throws Exception {
        //签名
        String sign= userSign.userSign(data);
        //获取apptoken
        String access_token= accessToken.getUsertoken();
        //发送get请求
        usertokenGetPrep.getRequests("APIurl","orgs",data,sign,access_token);

    }
}
