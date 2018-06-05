package ApiTest.usertokenTest.BeforeTest;

import CommonAPI.EnvInit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import requests.PostReuqests;

import java.util.HashMap;

/**
 * Created by lijing on 2018/6/4.
 * 获取用户授权码接口/pup-asserver/authorize： 从authdata.env.properties文件中读取参数
 */
public class authorize {

    @Test
    public void authorizeTest() throws Exception {
        HashMap<String, String> authorizeParams=EnvInit.getAuthorizeParams();
        PostReuqests.postRequests("SSOurl","authorize",authorizeParams);
    }

    // 获取授权码
    public static String getCode() throws Exception {
        HashMap<String, String> authorizeParams=EnvInit.getAuthorizeParams();
        String code=PostReuqests.postRequests("SSOurl","authorize",authorizeParams);
        return code;
    }
}
