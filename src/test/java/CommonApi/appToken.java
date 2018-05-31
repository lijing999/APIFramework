package CommonApi;

import com.alibaba.fastjson.JSONObject;
import junit.framework.Assert;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tool.EnvPropData;
import tool.ExcelNameData;

import java.io.IOException;
import java.util.*;

/**
 * Created by lijing on 2018/5/30.
 * 用excle获取接口参数和接口请求拼接
 */
public class appToken {
    public static CloseableHttpClient httpclient=null;
    public static String apiName="appToken";
   // public static String  access_token;


    @org.testng.annotations.BeforeClass
    public static void setUp(){
        httpclient= HttpClients.createDefault();

    }

    @DataProvider(name = "testdata")
    public Object[][]data(){
        ExcelNameData excelCase=new ExcelNameData();
        String file="E:\\API.xlsx";
        //String file="E:\\login.xlsx";
        return excelCase.testData(file,"apptoken");
    }

    @org.testng.annotations.Test(dataProvider= "testdata")
    public void getApptoken(HashMap<String, String> data) throws IOException {

        // 1. 获取请求地址参数
        Properties Prop= EnvPropData.getProperties("E:\\env.properties");
        String SSOurl=Prop.getProperty("SSOurl");
        String url=SSOurl+apiName+"?";
        System.out.print(url);


        List<String> keyName=new ArrayList<String>();
        List<String> keyValue=new ArrayList<String>();

        // 2. 获取接口输入参数
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : data.entrySet()) {
            System.out.println("key= " + entry.getKey() + " , value= " + entry.getValue());

            keyName.add(entry.getKey());
            keyValue.add(entry.getValue());
        }


        List<String>getUrl=new ArrayList<String>();
        for (int i=0;i<keyName.size();i++){
            String Url=keyName.get(i) +"="+ keyValue.get(i) + "&";
            getUrl.add(Url);
        }
        System.out.print(getUrl);//列表

        //列表拼接成字符串
        String requestUrl="";
        for (int i=0;i<getUrl.size();i++){
            requestUrl += getUrl.get(i);
        }


        System.out.print( "\n"+ requestUrl + "\n");

        String requestUrl1=requestUrl.substring(0,requestUrl.lastIndexOf("&"));
        System.out.println(requestUrl1);

        System.out.print(url+requestUrl1);

       // HttpGet httpGet=new HttpGet(url+ "client_id=" + data.get("client_id") + "&client_secret=" + data.get("client_secret"));
        HttpGet httpGet=new HttpGet(url+ requestUrl1);
        CloseableHttpResponse res = httpclient.execute(httpGet);
        String resBody=EntityUtils.toString(res.getEntity());
        System.out.println("\n" + resBody);

        //输出响应json数据解析，断言
        JSONObject jo = JSONObject.parseObject(resBody);
        String resultcode = jo.getString("result");
        String access_token=jo.getString("access_token");
        Assert.assertEquals("200", resultcode);
        System.out.println("result:" +resultcode);
        System.out.println("access_token:" +access_token);

        /*HttpGet httpGet=new HttpGet(getUrl+getUrl);
        CloseableHttpResponse res = httpclient.execute(httpGet);
        String resBody= EntityUtils.toString(res.getEntity());
        System.out.println(resBody);*/

    }


}
