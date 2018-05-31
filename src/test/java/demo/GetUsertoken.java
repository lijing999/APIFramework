package demo;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.runners.Parameterized;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tool.ExcelData;
import tool.ExcelNameData;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lijing on 2018/5/28.
 */


public class GetUsertoken {
    public static CloseableHttpClient httpclient=null;

    @DataProvider(name="testData")
    public Object[][]data(){
        ExcelNameData excelCase=new ExcelNameData();
        String file="E:\\API.xlsx";
        return excelCase.testData(file,"authorize");
    }

    @org.testng.annotations.Test(dataProvider = "testData")
    public static void getUsertoken(HashMap<String, String> data) throws IOException {

        //从excel文件中获取接口参数
        String client_id=data.get("client_id");
        System.out.println("client_id:" + client_id);
        String response_type=data.get("response_type");
        System.out.println("response_type:" + response_type);
        String redirect_uri=data.get("redirect_uri");
        System.out.println("redirect_uri:"+redirect_uri);
        String state=data.get("state");
        System.out.println("state:"+state);
        String username=data.get("username");
        System.out.println("username:"+username);
        String password=data.get("password");
        System.out.println("password:"+password);
        String available=data.get("available");
        System.out.println("available:"+available);

        //1.获取授权码POST请求
        String url="https://oauth.pre.hubpd.com/pup-asserver/authorize";
        HttpPost post=new HttpPost(url);
        List<NameValuePair> parameList=new ArrayList<NameValuePair>();
        parameList.add(new BasicNameValuePair("client_id", client_id));
        parameList.add(new BasicNameValuePair("response_type", response_type));
        parameList.add(new BasicNameValuePair("redirect_uri", redirect_uri));
        parameList.add(new BasicNameValuePair("state", state));
        parameList.add(new BasicNameValuePair("username", username));
        parameList.add(new BasicNameValuePair("password", password));
        parameList.add(new BasicNameValuePair("available", available));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameList, Charset.forName("utf-8"));//根据数据构造请求body部分,带&符号要编码
        post.setEntity(entity);
        System.out.println(parameList.get(6));
        CloseableHttpResponse res = httpclient.execute(post);
        String resBody= EntityUtils.toString(res.getEntity());
        System.out.println(resBody);

       // return resBody;

    }
}
