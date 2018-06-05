package ApiTest.apptokenTest.BeforeTest;

import CommonAPI.EnvInit;
import CommonApi.ExcelVersion.sign;
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
import java.util.HashMap;
import java.util.List;

/**
 * Created by lijing on 2018/6/5.
 * post请求参数中，包括 excel中的接口参数列表 mapdata ，加上sign、 access_token
 */
public class apptokenPostPrep {
    public static CloseableHttpClient httpclient = null;

    public static JSONObject postRequestsToJson(String urlname, String apiName, HashMap<String, String> mapdata, String sign,String access_token) throws IOException {

        httpclient = HttpClients.createDefault();
        String url= EnvInit.requestUrl(urlname,apiName);
        System.out.println("\n"+ "posturl="+ url);
        HttpPost post=new HttpPost(url);

        // excel中接口参数+签名+ accesstoken
        mapdata.put("sign",sign);
        mapdata.put("access_token",access_token);

        // excel参数读取：map转list
        List<NameValuePair> parameList= MapToList.mapToList(mapdata);

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameList, Charset.forName("utf-8"));
        post.setEntity(entity);
        CloseableHttpResponse res = httpclient.execute(post);
        String resBody= EntityUtils.toString(res.getEntity());
        System.out.println("resBody:" + resBody);

        //接口响应转json格式
        JSONObject jo = JSONObject.parseObject(resBody);

        //输出响应结果
        System.out.println(jo);

        return jo;

    }
}
