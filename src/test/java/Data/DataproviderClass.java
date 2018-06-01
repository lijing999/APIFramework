package Data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tool.MultiData;

import java.lang.reflect.Method;

/**
 * Created by lijing on 2018/6/1.
 */
public class DataproviderClass {

    @DataProvider(name = "create")
    public static Object[][] createData(Method m,String apiName) throws Exception {
        return getData(m.getName(),apiName);
    }

    public static Object[][] getData(String methodName,String apiName) throws Exception {
        Object[][] result = null;
        if(methodName.equals("sign")){
            result = MultiData.Ssodata();
        }else if(methodName.equals("getRequests")){
            result = MultiData.Apidata(apiName);
        }
        return result;
    }


}
