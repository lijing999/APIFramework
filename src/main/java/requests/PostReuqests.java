package requests;

import CommonAPI.EnvInit;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import tool.MapToList;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lijing on 2018/6/4.
 * 拼接接口请求地址：统一url+ apiname（sheetname)
 * 从excel中读取接口请求参数（map 转 list，post请求发送的参数为list类型）
 * 发送post请求：接口地址+list参数
 */
public class PostReuqests {
    public static CloseableHttpClient httpclient=null;

    public static String postRequests(String urlname, String apiName, HashMap<String, String> mapdata) throws IOException {
        httpclient = HttpClients.createDefault();
        String url= EnvInit.requestUrl(urlname,apiName);
        System.out.println("\n"+ "posturl="+ url);
        HttpPost post=new HttpPost(url);


        // excel参数读取：map转list
        List<NameValuePair> parameList= MapToList.mapToList(mapdata);

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameList, Charset.forName("utf-8"));
        post.setEntity(entity);
        CloseableHttpResponse res = httpclient.execute(post);
        String resBody=EntityUtils.toString(res.getEntity());
        System.out.println("resBody:" + resBody);

       /* //接口响应转json格式
        JSONObject jo = JSONObject.parseObject(resBody);

        //输出响应结果
        System.out.println(jo);

        return jo;*/

       return resBody;

    }

    public static JSONObject postRequestsToJson(String urlname, String apiName, HashMap<String, String> mapdata) throws IOException {
        httpclient = HttpClients.createDefault();
        String url= EnvInit.requestUrl(urlname,apiName);
        System.out.println("\n"+ "posturl="+ url);
        HttpPost post=new HttpPost(url);


        // excel参数读取：map转list
        List<NameValuePair> parameList= MapToList.mapToList(mapdata);

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameList, Charset.forName("utf-8"));
        post.setEntity(entity);
        CloseableHttpResponse res = httpclient.execute(post);
        String resBody=EntityUtils.toString(res.getEntity());
        System.out.println("resBody:" + resBody);

        //接口响应转json格式
        JSONObject jo = JSONObject.parseObject(resBody);

        //输出响应结果
        System.out.println(jo);

        return jo;



    }
}
