package CommonApi;

import CommonAPI.EnvInit;
import CommonApi.ExcelVersion.appToken;
import CommonApi.ExcelVersion.sign;
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
 * Created by lijing on 2018/6/1.
 * 应用token访问api接口前的预置条件
 * 应用token访问api时，需要拼接应用access_token参数和sign参数
 */
public class apiRequests {
    public static CloseableHttpClient httpclient = null;

    public static JSONObject getRequests(String urlname, String apiName, HashMap<String, String> mapdata) throws IOException {
        httpclient = HttpClients.createDefault();

        // 1. 获取请求地址参数

        /*Properties Prop= EnvPropData.getProperties("E:\\env.properties");
        String requestUrl=Prop.getProperty(urlname);
        requestUrl=requestUrl+apiName+"?";
        System.out.print("requestUrl:"+requestUrl);*/


        String requestUrl = EnvInit.requestUrl(urlname, apiName);

        // 参数拼接+签名+ accesstoken
        mapdata.put("sign", sign.sign(mapdata));
        mapdata.put("access_token", appToken.appToken(mapdata));

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
