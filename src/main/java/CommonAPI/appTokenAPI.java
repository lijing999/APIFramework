package CommonAPI;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import tool.EnvPropData;
import tool.ExcelNameData_map;
import tool.ObjectToMap;

import java.io.IOException;
import java.util.*;

//import static CommonAPI.EnvInit.apiName;

/**
 * Created by lijing on 2018/5/30.
 */
public class appTokenAPI {
    public static CloseableHttpClient httpclient = null;

  /*  public static HashMap<String, Object> mapdata() throws Exception {
        Object[][] data= EnvInit.EnvInitTest();
        //data转换为HashMap类型???????????????? !!!!!!!!!!!!!!

        //Map<String, Object> mapdata = ObjectToMap.objectToMap(data);
        //return (HashMap<String, Object>) mapdata;

    }*/



    public void getApptoken(HashMap<String, String>[][] mapdata) throws IOException {




       /* // 1. 获取请求地址参数
        Properties Prop = EnvPropData.getProperties("E:\\env.properties");
        String SSOurl = Prop.getProperty("SSOurl");
        String url = SSOurl + apiName + "?";
        System.out.print(url);


        List<String> keyName = new ArrayList<String>();
        List<String> keyValue = new ArrayList<String>();

        // 2. 获取接口输入参数
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : mapdata.entrySet()) {
            System.out.println("key= " + entry.getKey() + " , value= " + entry.getValue());

            keyName.add(entry.getKey());
            keyValue.add(entry.getValue());
        }


        List<String> getUrl = new ArrayList<String>();
        for (int i = 0; i < keyName.size(); i++) {
            String Url = keyName.get(i) + "=" + keyValue.get(i) + "&";
            getUrl.add(Url);
        }
        System.out.print(getUrl);//列表

        //列表拼接成字符串
        String requestUrl = "";
        for (int i = 0; i < getUrl.size(); i++) {
            requestUrl += getUrl.get(i);
        }


        System.out.print("\n" + requestUrl + "\n");

        String requestUrl1 = requestUrl.substring(0, requestUrl.lastIndexOf("&"));
        System.out.println(requestUrl1);

        System.out.print(url + requestUrl1);

        // HttpGet httpGet=new HttpGet(url+ "client_id=" + data.get("client_id") + "&client_secret=" + data.get("client_secret"));
        HttpGet httpGet = new HttpGet(url + requestUrl1);
        CloseableHttpResponse res = httpclient.execute(httpGet);
        String resBody = EntityUtils.toString(res.getEntity());
        System.out.println("\n" + resBody);

        //输出响应json数据解析，断言
        JSONObject jo = JSONObject.parseObject(resBody);
        String resultcode = jo.getString("result");
        String access_token = jo.getString("access_token");
        //Assert.assertEquals("200", resultcode);
        System.out.println("result:" + resultcode);
        System.out.println("access_token:" + access_token);

        return access_token;

        *//*HttpGet httpGet=new HttpGet(getUrl+getUrl);
        CloseableHttpResponse res = httpclient.execute(httpGet);
        String resBody= EntityUtils.toString(res.getEntity());
        System.out.println(resBody);*//*

    }
*/
    }
}
