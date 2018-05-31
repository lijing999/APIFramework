package demo;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.DataProvider;
import tool.ExcelNameData;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lijing on 2018/5/29.
 */
public class GetAuthCode {
    public static CloseableHttpClient httpclient=null;

    @org.testng.annotations.BeforeClass
    public static void setUp(){

        httpclient= HttpClients.createDefault();
    }

    /**
     * 从excel文件中获取接口参数
     * 定义了API.xlsx 文件，每个sheet也对应一个接口的参数
     * @return
     */



    @org.testng.annotations.Test()
    public void getAuthcodeTest() throws ClientProtocolException, IOException {



        //1.获取授权码POST请求
        String url="https://oauth.pre.hubpd.com/pup-asserver/authorize";
        HttpPost post=new HttpPost(url);
        List<NameValuePair> parameList=new ArrayList<NameValuePair>();
        parameList.add(new BasicNameValuePair("client_id", "b38425e7ce9249f4a5f2acad8d8308a3"));
        parameList.add(new BasicNameValuePair("response_type", "code"));
        parameList.add(new BasicNameValuePair("redirect_uri", "json:http://pdmi-test.teambition.net"));
        parameList.add(new BasicNameValuePair("state", "ABCD"));
        parameList.add(new BasicNameValuePair("username", "testcb0528"));
        parameList.add(new BasicNameValuePair("password", "111111"));
        parameList.add(new BasicNameValuePair("available", "0"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameList, Charset.forName("utf-8"));//根据数据构造请求body部分,带&符号要编码
        post.setEntity(entity);
        CloseableHttpResponse res = httpclient.execute(post);
        String resBody= EntityUtils.toString(res.getEntity());
        System.out.println("resBody:" + resBody);
    }
}
