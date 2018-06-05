package ApiTest.usertokenTest.BeforeTest;

import CommonAPI.EnvInit;
import com.chinasofti.oauth2.rsserver.util.SignatureUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lijing on 2018/6/5.
 */
public class userSign {
    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","orgs");
        return testdata;
    }
    @Test(dataProvider = "testData")
    public static void userSignTest(HashMap<String, String> signdatas) throws Exception {
        //获取access_token参数
       String access_token= accessToken.getUsertoken();
        // 签名：access_token & orgs参数
        signdatas.put("access_token", access_token);
        for (String key : signdatas.keySet()) {
            System.out.println(key + "=" + signdatas.get(key));
        }


        //Converting Map<String,String> to Map<String,Object>
        Map<String, Object> MapObj=new  HashMap<String, Object>();
        if (signdatas != null) {
            for (Map.Entry<String, String> entry : signdatas.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Object objectVal = (Object)value;
                MapObj.put(key, objectVal);
            }
        }


        String paramStr = SignatureUtil.sortParameters(MapObj);
        String sign = SignatureUtil.createSignature(paramStr);

        System.out.println("sign:" + sign);

    }

    public static String  userSign(HashMap<String, String> signdatas) throws Exception {
        //获取access_token参数
        String access_token= accessToken.getUsertoken();
        // 签名：access_token & orgs参数
        signdatas.put("access_token", access_token);
        for (String key : signdatas.keySet()) {
            System.out.println(key + "=" + signdatas.get(key));
        }


        //Converting Map<String,String> to Map<String,Object>
        Map<String, Object> MapObj=new  HashMap<String, Object>();
        if (signdatas != null) {
            for (Map.Entry<String, String> entry : signdatas.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Object objectVal = (Object)value;
                MapObj.put(key, objectVal);
            }
        }


        String paramStr = SignatureUtil.sortParameters(MapObj);
        String sign = SignatureUtil.createSignature(paramStr);

        System.out.println("sign:" + sign);

        return sign;

    }
}
