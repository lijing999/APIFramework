package ToolTest;

import CommonAPI.EnvInit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requests.PostReuqests;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by lijing on 2018/6/4.
 */
public class PostRequestsTest {
    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","authorize");
        return testdata;
    }

    @Test(dataProvider = "testData")
    public void postRequest(HashMap<String, String> Mapdatas) throws IOException {
        PostReuqests.postRequests("SSOurl","authorize",Mapdatas);
    }

    public String postRequests(HashMap<String, String> Mapdatas) throws IOException {
        String code=PostReuqests.postRequests("SSOurl","authorize",Mapdatas);
        return code;
    }
}
