package demo;

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
 * 未完成...........
 * Created by lijing on 2018/6/1.
 * 应用token访问前的预置条件：
 * 1.
 */
public class appApiPrep {
    public static CloseableHttpClient httpclient = null;

    public static JSONObject getRequests(String urlname, String apiName, HashMap<String, String> mapdata, String sign) throws IOException {
        httpclient = HttpClients.createDefault();

        // 1. 获取请求地址参数

        /*Properties Prop= EnvPropData.getProperties("E:\\env.properties");
        String requestUrl=Prop.getProperty(urlname);
        requestUrl=requestUrl+apiName+"?";
        System.out.print("requestUrl:"+requestUrl);*/


        String requestUrl = EnvInit.requestUrl(urlname, apiName);

        // 参数拼接+签名+ accesstoken


        // 2. map转url：&拼接参数
        String Parameters = MapToUrl.mapTourl(mapdata);

        //3. 请求地址+ 参数拼接
        String GetUrl = requestUrl + Parameters;


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
