package ToolTest;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijing on 2018/5/30.
 */
public class ParamTest {
    public static CloseableHttpClient httpclient=null;

    @org.testng.annotations.BeforeClass
    public static void setUp(){
        httpclient= HttpClients.createDefault();
    }


    @Parameters({"client_id","response_type","redirect_uri","state","username","password","available"})
    @Test(groups = "parameter")
    public void TestParam(String client_id,String response_type,String redirect_uri,String state,String username,String password,String available) throws IOException {
        System.out.println(client_id);
        System.out.println(response_type);
        System.out.println(redirect_uri);
        System.out.println(username);
        System.out.println(password);
        System.out.println(available);



        String url="https://oauth.pre.hubpd.com/pup-asserver/authorize";
        System.out.println(url);
        HttpPost post=new HttpPost(url);
        List<NameValuePair> parameList=new ArrayList<NameValuePair>();
        parameList.add(new BasicNameValuePair("client_id", client_id));
        System.out.println("hello"+client_id);
        parameList.add(new BasicNameValuePair("response_type", response_type));
        parameList.add(new BasicNameValuePair("redirect_uri", redirect_uri));
        parameList.add(new BasicNameValuePair("state", state));
        parameList.add(new BasicNameValuePair("username", username));
        parameList.add(new BasicNameValuePair("password", password));
        parameList.add(new BasicNameValuePair("available", available));
        System.out.println(parameList.get(1));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameList, Charset.forName("utf-8"));//根据数据构造请求body部分,带&符号要编码
        System.out.println("ok");
        post.setEntity(entity);
        CloseableHttpResponse res = httpclient.execute(post);
        String resBody= EntityUtils.toString(res.getEntity());

    }
}
