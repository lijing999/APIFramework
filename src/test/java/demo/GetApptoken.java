package demo;

import CommonAPI.EnvInit;
import CommonApi.ExcelVersion.appToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by lijing on 2018/6/1.
 */
public class GetApptoken {


    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","apptoken");
        return testdata;
    }
    @Test(dataProvider = "testData")
    public void getApptoken(HashMap<String, String> data) throws IOException {
        /*JSONObject res= appTokenAPITest.appToken(data);
        String access_token=res.getString("access_token");
        System.out.println("access_token:" + access_token);*/

        String access_token=appToken.appToken(data);
        System.out.println("access_token:" + access_token);
    }


}
