package CommonApi;

import CommonAPI.EnvInit;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by lijing on 2018/5/29.
 */
public class accessToken {
    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","apptoken");
        return testdata;
    }
    /*@Test(dataProvider = "testData")
    public void getApptoken(HashMap<String, String> data) throws IOException {
        JSONObject res= appTokenAPITest.appToken(data);
        String access_token1=res.getString("access_token1");
        System.out.println("access_token:" + access_token1);
    }*/

}
