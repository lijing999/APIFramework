package requests;

import CommonAPI.EnvInit;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import tool.EnvPropData;
import tool.MapToUrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by lijing on 2018/5/31.
 * 环境初始化：EnvInit
 * 拼接请求地址和接口请求参数为get请求url
 * 根据excel页签apiname获取对应api的参数：map对象数组
 * 将map参数拼接为&链接的url字符串
 * 发送get(url)请求
 */
public class GetRequests {
    public static CloseableHttpClient httpclient=null;

    public static JSONObject getRequests(String urlname,String apiName,HashMap<String, String>mapdata) throws IOException {
        httpclient= HttpClients.createDefault();

        // 1. 获取请求地址参数
        String requestUrl=EnvInit.requestUrl(urlname,apiName);

        // 2. map转url：&拼接参数
        String Parameters= MapToUrl.mapTourl(mapdata);

        //3. 请求地址+ 参数拼接
        String GetUrl=requestUrl+Parameters;



        // 3. 发送get请求
        HttpGet httpGet=new HttpGet(GetUrl);
        CloseableHttpResponse res = httpclient.execute(httpGet);
        String resBody=EntityUtils.toString(res.getEntity());
        //System.out.println("\n"+"Response:"+"\n"+resBody);


        //4. 接口响应转json格式
        JSONObject jo = JSONObject.parseObject(resBody);

        //输出响应结果
        System.out.println(jo);

        return jo;



    }
}
