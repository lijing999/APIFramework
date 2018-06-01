package CommonAPI;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import tool.EnvPropData;
import tool.ExcelNameData;
import tool.ObjectToMap;

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





}
