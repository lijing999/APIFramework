package CommonAPI;

import org.apache.http.impl.client.CloseableHttpClient;
import tool.EnvPropData;
import tool.ExcelNameData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by lijing on 2018/5/30.
 * 获取请求地址，拼接接口请求地址
 * 获取请求参数，存放到map[][]对象中
 */
public class EnvInit  {
    public static CloseableHttpClient httpclient = null;
    //public static String apiName = "appToken";
    // public static String  access_token;

    public static String  requestUrl(String urlname,String apiName) throws IOException {
        Properties Prop= EnvPropData.getProperties("E:\\env.properties");
        String requestUrl=Prop.getProperty(urlname);
        requestUrl=requestUrl+apiName+"?";
        System.out.print("requestUrl:"+requestUrl);
        return requestUrl;
    }



    public static  HashMap<String, String>[][] EnvInitTest(String file,String sheetname) throws Exception {
        ExcelNameData excelCase = new ExcelNameData();
        HashMap<String, String>[][] maps = (HashMap<String, String>[][]) excelCase.testData(file, sheetname);
        return maps;
    }

    //从 E:\AuthData.properties 中获取参数

    public static HashMap<String, String> getAuthData() throws Exception {
        Properties properties=EnvPropData.getProperties("E:\\AuthData.properties");
        String client_id=properties.getProperty("client_id");
        String client_secret=properties.getProperty("client_secret");
        HashMap<String, String> authdatas = new HashMap<String, String>();
        authdatas.put("client_id",client_id);
        authdatas.put("client_secret",client_secret);
        return authdatas;
    }



}
