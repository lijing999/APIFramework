package demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.DataProvider;
import tool.EnvPropData;
import tool.ExcelData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by lijing on 2018/5/22.
 */
public class get_api_ExcelDriven {
    public static CloseableHttpClient httpclient= HttpClients.createDefault();
    // httpclient= HttpClients.createDefault();

    /*@BeforeClass
    public static void setUp(){
        httpclient= HttpClients.createDefault();

    }*/

    @DataProvider(name="testData")
    public Object[][]data(){
        ExcelData excelCase=new ExcelData();
        String file="E:\\test.xlsx";
        return excelCase.testData(file,0);
    }

    @org.testng.annotations.Test(dataProvider = "testData")
    public void getUsertoken(HashMap<String, String> data) throws ClientProtocolException, IOException {
        //1.获取access_token
//        String client_id="261a7f2196c7450580d200720c1b8b0d";
//        String client_secret="1f26e53d0fce418793cd6e822ef2ba22";

        //clientid和clientSecret参数用excel文件读取
        String ClientId=data.get("client_id");
        System.out.println("client_id:" + ClientId);
        String ClientSecret=data.get("client_secret");
        System.out.println("client_secret:" + ClientSecret);
        String UserName=data.get("username");
        System.out.println("username:"+UserName);
        String Pwd=data.get("password");
        System.out.println("password:"+Pwd);

        //从envproperties文件中获取用户token的url
        String filepath="E:\\env.properties";
        Properties pro= EnvPropData.getProperties(filepath);
         String usertokenUrl=pro.getProperty("usertokenUrl");
        System.out.println(usertokenUrl);
        HttpGet httpGet=new HttpGet(usertokenUrl+"client_id="+ ClientId + "&client_secret=" + ClientSecret);
        CloseableHttpResponse res = httpclient.execute(httpGet);
        String resBody= EntityUtils.toString(res.getEntity());
        System.out.println(resBody);



        //2.提取access_token的值
        JSONObject jo = JSONObject.parseObject(resBody);
        System.out.println(jo.toString());
        String Access_token=jo.getString("access_token");
        System.out.println(Access_token);



    }

}
