package CommonApi;

import CommonAPI.EnvInit;
import CommonApi.ExcelVersion.appToken;
import com.chinasofti.oauth2.rsserver.util.SignatureUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lijing on 2018/6/1.
 * 计算签名的参数包括 access_token和接口入参
 * 依赖于2组excel数据
 */
public class signs {
    // 获取接口输入参数
    @DataProvider(name="testData1")
    public Object[][] data1() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","orgs");
        return testdata;
    }

    @Test(dataProvider = "testData")
    public void signTest(HashMap<String, String> data) throws IOException {
        Map parameters = new HashMap();
        //parameters.putAll(data1);
        parameters.put("access_token", appToken.appToken(data) );

        String paramStr = SignatureUtil.sortParameters(parameters);
        String sign = SignatureUtil.createSignature(paramStr);

        System.out.println("sign:" + sign);

    }
}
