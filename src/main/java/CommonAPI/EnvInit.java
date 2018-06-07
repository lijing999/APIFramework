package CommonAPI;

import org.apache.http.impl.client.CloseableHttpClient;
import tool.EnvPropData;
import tool.ExcelNameData;
import tool.strReplacement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by lijing on 2018/5/30.
 * authdata.proerties中：获取asserver接口请求参数放到map里，用作 拼接获取access_token的接口请求地址
 * API.xlsx中：获取api接口请求参数，存放到map[][]对象中
 * env.properties中：获取api接口请求地址 （url+apiname)
 */
public class EnvInit  {
    public static CloseableHttpClient httpclient = null;
    //public static String apiName = "appToken";
    // public static String  access_token;


    // 获取接口请求地址 （url+apiname)
    public static String  requestUrl(String urlname,String apiName) throws IOException {
        Properties Prop= EnvPropData.getProperties("E:\\env.properties");
        String requestUrl=Prop.getProperty(urlname);

        //如果apiName中包含"_"，把空格转换为/
        String replacedapiName="";
        if (apiName.contains("_")){
            replacedapiName= strReplacement.strReplace(apiName);
            System.out.println("\n"+"replacedapiName="+replacedapiName);
            requestUrl=requestUrl+replacedapiName+"?";
            System.out.print("requestUrl:"+requestUrl);
            return requestUrl;
        }else {
            requestUrl=requestUrl+apiName+"?";
            System.out.print("requestUrl:"+requestUrl);
            return requestUrl;
        }


    }

    // pup-asserver : 从 E:\AuthData.properties 中获取apptoken接口参数
    public static HashMap<String, String> getAuthData() throws Exception {
        Properties properties=EnvPropData.getProperties("E:\\AuthData.properties");
        String client_id=properties.getProperty("client_id");
        String client_secret=properties.getProperty("client_secret");
        HashMap<String, String> authdatas = new HashMap<String, String>();
        authdatas.put("client_id",client_id);
        authdatas.put("client_secret",client_secret);
        return authdatas;
    }

    // pup-asserver : 从 E:\AuthData.properties 中获取authorize接口参数
    public static HashMap<String, String> getAuthorizeParams() throws Exception {
        Properties properties=EnvPropData.getProperties("E:\\AuthData.properties");
        String client_id=properties.getProperty("client_id");
        String response_type=properties.getProperty("response_type");
        String redirect_uri=properties.getProperty("redirect_uri");
        String state=properties.getProperty("state");
        String username=properties.getProperty("username");
        String password=properties.getProperty("password");
        String available=properties.getProperty("available");
        HashMap<String, String> AuthorizeParams = new HashMap<String, String>();
        AuthorizeParams.put("client_id",client_id);
        AuthorizeParams.put("response_type",response_type);
        AuthorizeParams.put("redirect_uri",redirect_uri);
        AuthorizeParams.put("state",state);
        AuthorizeParams.put("username",username);
        AuthorizeParams.put("password",password);
        AuthorizeParams.put("available",available);
        return AuthorizeParams;
    }

    // pup-asserver : 从 E:\AuthData.properties 中获取authorize接口参数
    public static HashMap<String, String> getAccesstokenParams() throws Exception {
        Properties properties=EnvPropData.getProperties("E:\\AuthData.properties");
        String client_id=properties.getProperty("client_id");
        String client_secret=properties.getProperty("client_secret");
        String grant_type=properties.getProperty("grant_type");
        String redirect_uri=properties.getProperty("redirect_uri");

        HashMap<String, String> AccesstokenParams = new HashMap<String, String>();
        AccesstokenParams.put("client_id",client_id);
        AccesstokenParams.put("client_secret",client_secret);
        AccesstokenParams.put("grant_type",grant_type);
        AccesstokenParams.put("redirect_uri",redirect_uri);

        return AccesstokenParams;
    }

    //从excel中获取接口参数，放到map对象中
    public static  HashMap<String, String>[][] EnvInitTest(String file,String sheetname) throws Exception {
        ExcelNameData excelCase = new ExcelNameData();
        HashMap<String, String>[][] maps = (HashMap<String, String>[][]) excelCase.testData(file, sheetname);
        return maps;
    }









}
