package ApiTest.Test.ApiGetTest;

import CommonAPI.EnvInit;
import CommonApi.apiRequests;
import CommonApi.sign;
import Data.DataproviderClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requests.GetRequests;
import tool.MultiData;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by lijing on 2018/6/1.
 */
public class orgsTest {

    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","apptoken");
        return testdata;
    }

    @Test(dataProvider = "testData")
    public void orgsTest(HashMap<String, String> data) throws IOException {
        apiRequests.getRequests("APIurl","orgs",data);
    }



   /* @DataProvider
    public Object[][] providerMethod(Method method,String apiName) throws Exception {
        Object[][] result = null;
        if(method.getName().equals("sign")){
            result = MultiData.Ssodata();
        }else if(method.getName().contains(apiName)){
            result = MultiData.Apidata(apiName);
        }
        return result;
    }

    @Test(dataProvider = "providerMethod")
    public void sign(HashMap<String, String> tokenData) throws IOException {
        sign.sign(tokenData);
    }

    @Test(dataProvider = "providerMethod")
    public void orgsTest(HashMap<String, String> Apidata) throws Exception {

        //get访问api/orgs
        GetRequests.getRequests("APIurl","orgs",Apidata);

    }

    *//*@Test(dataProvider = "create", dataProviderClass = DataproviderClass.class)
    public void test1() throws IOException {
        sign.sign(DataproviderClass.getData());
        GetRequests.getRequests("APIurl","orgs",Apidata);
    }*/
}
