package requests;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import tool.EnvPropData;

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

    public void getRequests(String urlname,String apiName,HashMap<String, String>[][]mapdata) throws IOException {
        httpclient= HttpClients.createDefault();

        // 1. 获取请求地址参数
        Properties Prop= EnvPropData.getProperties("E:\\env.properties");
        String requestUrl=Prop.getProperty(urlname);
        requestUrl=requestUrl+apiName+"?";
        System.out.print("requestUrl:"+requestUrl);

        // 2. map转url：&拼接参数
        StringBuffer sb = new StringBuffer();

        for (int i=0;i<mapdata.length;i++){
            for (int j=0;j<mapdata[i].length;j++){
                for (Map.Entry<String, String> entry:mapdata[i][j].entrySet()) {
                    System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                    sb.append(entry.getKey() + "=" + entry.getValue());
                    sb.append("&");
                    String requestUrl1 = sb.toString();
                    if (requestUrl1.endsWith("&")) {
                        requestUrl1 = StringUtils.substringBeforeLast(requestUrl1, "&");
                    }
                    System.out.println("\n" + "requestUrl1:"+requestUrl1);

                    String linkurl=requestUrl+requestUrl1;

                    System.out.println("\n" + "linkurl:"+linkurl);
                }
            }
        }




    }
}
