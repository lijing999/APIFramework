package CommonApi.ExcelVersion;

import CommonAPI.EnvInit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.chinasofti.oauth2.rsserver.util.SignatureUtil;

/**
 * Created by lijing on 2018/5/30.
 * 计算签名的参数有access_token
 */
public class sign {

    /**
     * 计算签名，需要 访问接口参
     * @return
     * @throws Exception
     */


    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","apptoken");
        return testdata;
    }
    @Test(dataProvider = "testData")
    public void signTest(HashMap<String, String> data) throws  IOException{
        Map parameters = new HashMap();
        //parameters.putAll(data1);
        parameters.put("access_token", appToken.appToken(data) );

        String paramStr = SignatureUtil.sortParameters(parameters);
        String sign = SignatureUtil.createSignature(paramStr);

       System.out.println("sign:" + sign);

    }

    // 签名接口，可调用获取 : 只有access_token参数时
    public static String sign(HashMap<String, String> data) throws  IOException{
        Map parameters = new HashMap();
        //parameters.putAll(data1);
        parameters.put("access_token",appToken.appToken(data) );

        String paramStr = SignatureUtil.sortParameters(parameters);
        String sign = SignatureUtil.createSignature(paramStr);

        System.out.println("sign:" + sign);
        return sign;
    }

}
