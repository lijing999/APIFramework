package demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import tool.EnvPropData;
import tool.ExcelNameData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by lijing on 2018/5/30.
 */
public class GetRequest {
    public static CloseableHttpClient httpclient=null;


    /**
     *
     * @param url
     * @param apiName
     * @param data
     * @return
     * @throws IOException
     */
    public static String getRequest(String url,String apiName,HashMap<String, String> data) throws IOException {
        httpclient= HttpClients.createDefault();

        // 1. 获取请求地址参数
        Properties Prop= EnvPropData.getProperties("E:\\env.properties");
        String requestUrl=Prop.getProperty(url);
        requestUrl=requestUrl+apiName+"?";
        System.out.print("requestUrl:"+requestUrl);

        // 2. map转url：&拼接参数
        /*if (data == null) {
            return "输入为空！";
        }*/
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String requestUrl1 = sb.toString();
        if (requestUrl1.endsWith("&")) {
            requestUrl1 = StringUtils.substringBeforeLast(requestUrl1, "&");
        }
        System.out.println("\n" + "requestUrl1:"+requestUrl1);

        String linkurl=requestUrl+requestUrl1;

        System.out.println("\n" + "linkurl:"+linkurl);

        // 3. 发送get请求
        HttpGet httpGet=new HttpGet(linkurl);
        CloseableHttpResponse res = httpclient.execute(httpGet);
        String resBody=EntityUtils.toString(res.getEntity());
        System.out.println("\n" + resBody);
        return resBody;

    }
}
