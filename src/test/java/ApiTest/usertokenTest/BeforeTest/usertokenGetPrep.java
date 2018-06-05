package ApiTest.usertokenTest.BeforeTest;

import CommonAPI.EnvInit;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import tool.MapToUrl;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by lijing on 2018/6/5.
 * 拼接参数：excel中接口参数+签名+access_token
 */
public class usertokenGetPrep {
    public static CloseableHttpClient httpclient = null;

    public static JSONObject getRequests(String urlname, String apiName, HashMap<String, String> mapdata, String sign, String access_token) throws IOException {
        httpclient = HttpClients.createDefault();

        // 1. 获取请求地址参数

        String requestUrl = EnvInit.requestUrl(urlname, apiName);

        // 参数拼接+签名+ accesstoken
        mapdata.put("sign",sign);
        mapdata.put("access_token",access_token);


        // 2. map转url：&拼接参数
        String Parameters = MapToUrl.mapTourl(mapdata);

        //3. 请求地址+ 参数拼接
        String GetUrl = requestUrl + Parameters;
        System.out.println("GetUrl:"+ GetUrl);


        // 3. 发送get请求
        HttpGet httpGet = new HttpGet(GetUrl);
        CloseableHttpResponse res = httpclient.execute(httpGet);
        String resBody = EntityUtils.toString(res.getEntity());
        System.out.println("\n" + "Response:" + "\n" + resBody);


        //4. 接口响应转json格式
        JSONObject jo = JSONObject.parseObject(resBody);

        //输出响应结果
        System.out.println(jo);

        return jo;
    }
}
