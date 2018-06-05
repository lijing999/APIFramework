package ApiTest.apptokenTest.GetTest;

import ApiTest.apptokenTest.BeforeTest.appSign;
import ApiTest.apptokenTest.BeforeTest.apptoken;
import demo.apptokenGetPrep;
import CommonAPI.EnvInit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by lijing on 2018/6/1.
 */
public class orgsTest {

    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","orgs");
        return testdata;
    }




    @Test(dataProvider = "testData")
    public void appOrgsTest(HashMap<String, String> data) throws Exception {
        //签名
        String sign= appSign.getSign(data);
        //获取apptoken
        String access_token= apptoken.getApptoken();
        //发送get请求
        apptokenGetPrep.getRequests("APIurl","orgs",data,sign,access_token);

    }

}
