package ToolTest;

import CommonAPI.EnvInit;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lijing on 2018/5/30.
 */
public class EnvInitTest {

    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\test.xlsx","ssodata");
        return testdata;
    }

    @Test(dataProvider = "testData")
    public void envInitTest(HashMap<String, String> data) throws Exception {


        /*if (EnvInit.EnvInitTest() == null) {
            return ;
        }*/
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String requestUrl1 = sb.toString();
        if (requestUrl1.endsWith("&")) {
            requestUrl1 = StringUtils.substringBeforeLast(requestUrl1, "&");
        }
        System.out.println(requestUrl1);
    }



}
