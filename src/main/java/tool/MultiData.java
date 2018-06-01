package tool;

import CommonAPI.EnvInit;

import java.lang.reflect.Method;

/**
 * Created by lijing on 2018/6/1.
 */
public class MultiData {
    public static Object[][] Ssodata() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","apptoken");
        return testdata;
    }


    public static Object[][] Apidata(String apiName) throws Exception {
        Object[][] Apidata= EnvInit.EnvInitTest("E:\\API.xlsx",apiName);
        return Apidata;
    }



    /*public Object[][] providerMethod(Method method,String apiName) throws Exception {
        Object[][] result = null;
        if(method.getName().equals("sign")){
            result = MultiData.Ssodata();
        }else if(method.getName().equals("Apidata")){
            result = MultiData.Apidata(apiName);
        }
        return result;
    }*/
}
