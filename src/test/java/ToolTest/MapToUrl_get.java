package ToolTest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tool.EnvPropData;
import tool.ExcelNameData;
import demo.ExcelNameData_map;

import java.io.IOException;
import java.util.*;

/**
 * Created by lijing on 2018/5/30.
 */
public class MapToUrl_get {
    public static CloseableHttpClient httpclient=null;
    public static String apiName="appToken";

    @org.testng.annotations.BeforeClass
    public static void setUp(){
        httpclient= HttpClients.createDefault();

    }

    @DataProvider(name = "testdata")
    public Object[][]data(){
        ExcelNameData excelCase=new ExcelNameData();
        String file="E:\\API.xlsx";
        //String file="E:\\login.xlsx";
        return excelCase.testData(file,"apptoken");
    }

    @org.testng.annotations.Test(dataProvider= "testdata")
    public void getApptoken(HashMap<String, String> data) throws IOException {

        // 1. 获取请求地址参数
        Properties Prop= EnvPropData.getProperties("E:\\env.properties");
        String SSOurl=Prop.getProperty("SSOurl");
        String url=SSOurl+apiName+"?";
        System.out.print(url);


        List<String> keyName=new ArrayList<String>();
        List<String> keyValue=new ArrayList<String>();

        // 2. 获取接口输入参数
       /* System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : data.entrySet()) {
            System.out.println("key= " + entry.getKey() + " , value= " + entry.getValue());

            keyName.add(entry.getKey());
            keyValue.add(entry.getValue());
        }


        List<String>getUrl=new ArrayList<String>();
        for (int i=0;i<keyName.size();i++){
            String Url=keyName.get(i) +"="+ keyValue.get(i) + "&";
            getUrl.add(Url);
        }
        System.out.print(getUrl);//列表

        //列表拼接成字符串
        String requestUrl="";
        for (int i=0;i<getUrl.size();i++){
            requestUrl += getUrl.get(i);
        }


        System.out.print( "\n"+ requestUrl + "\n");

        String requestUrl1=requestUrl.substring(0,requestUrl.lastIndexOf("&"));
        System.out.println(requestUrl1);*/

        //System.out.print(url+requestUrl1);

        // map转url：&拼接
        if (data == null) {
            return ;
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String requestUrl1 = sb.toString();
        if (requestUrl1.endsWith("&")) {
            requestUrl1 = StringUtils.substringBeforeLast(requestUrl1, "&");
        }
        System.out.println(requestUrl1);

        // HttpGet httpGet=new HttpGet(url+ "client_id=" + data.get("client_id") + "&client_secret=" + data.get("client_secret"));
        HttpGet httpGet=new HttpGet(url+ requestUrl1);
        CloseableHttpResponse res = httpclient.execute(httpGet);
        String resBody= EntityUtils.toString(res.getEntity());
        System.out.println("\n" + resBody);

        /*HttpGet httpGet=new HttpGet(getUrl+getUrl);
        CloseableHttpResponse res = httpclient.execute(httpGet);
        String resBody= EntityUtils.toString(res.getEntity());
        System.out.println(resBody);*/



    }

    /**
     * excel返回map数组，获取多组map对象
     * 将每组map都拼接为&连接的接口请求参数
     */
    @Test
    public void mapToUrlTest(){
        ExcelNameData_map excelCase=new ExcelNameData_map();
        String file="E:\\test.xlsx";
        //String file="E:\\login.xlsx";
        HashMap<String, String>[][] mapdata = excelCase.testData(file, "pupdata");
        System.out.println(mapdata.length);

        StringBuffer[] sb = new StringBuffer[mapdata.length];

        String[] requestUrl=new String[mapdata.length];


        for (int i=0;i<mapdata.length;i++){
            StringBuffer[] sa = new StringBuffer[mapdata[i].length];
            for (int j=0;j<mapdata[i].length;j++){
                for (Map.Entry<String, String> entry:mapdata[i][j].entrySet()) {
                   // System.out.println("key= " + entry.getKey() + " "+ "value= " + entry.getValue());
                    System.out.println( entry.getKey() + "= "+ entry.getValue());
                    /**
                     * StringBuffer[] stringBuffers = new StringBuffer[10];
                        这只是声明了 10个 StringBuffer 的变量 并没有创建对象
                         stringBuffers[i] = new StringBuffer(); 这是给变量创建对象
                     */
                    sb[i] = new StringBuffer();
                    sb[i].append(entry.getKey() + "=" + entry.getValue()).toString();
                    sb[i].append("&");
                    System.out.println(sb[i].toString());

                }



                    /*requestUrl[i]=new String();
                   *//* requestUrl[i]=sb[i].toString();
                    System.out.println( requestUrl[i]);*/
            }
           /* requestUrl[i]=sb[i].toString();
            if (requestUrl[i].endsWith("&")) {
                requestUrl[i] = StringUtils.substringBeforeLast( requestUrl[i], "&");
            }
            System.out.println("\n"+ "第" + i + "组请求参数为："+ requestUrl[i]);*/


        }
    }

    @Test
    public void tempTest(){
       /* String [] s=new String[]{"password=admin1234&","username=admin&"};
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<2;i++){

            sb.append(s[i]);
        }
        System.out.println(sb.toString());

*/
        ExcelNameData_map excelCase=new ExcelNameData_map();
        String file="E:\\test.xlsx";
        //String file="E:\\login.xlsx";
        HashMap<String, String>[][] mapdata = excelCase.testData(file, "pupdata");
        System.out.println(mapdata.length);

        StringBuffer[] sb = new StringBuffer[mapdata.length];
        StringBuffer[] sb1 = new StringBuffer[mapdata.length];

        String[] param=new String[mapdata.length];

        for (int i=0;i<mapdata.length;i++){
            StringBuffer[] sa = new StringBuffer[mapdata[i].length];
            System.out.println(mapdata[i].length);

            for (int j=0;j<mapdata[i].length;j++){
                System.out.println(mapdata[i][j].size());

                    for (Map.Entry<String, String> entry:mapdata[i][j].entrySet()) {
                        // System.out.println("key= " + entry.getKey() + " "+ "value= " + entry.getValue());

                        System.out.println( entry.getKey() + "= "+ entry.getValue());
                        /**
                         * StringBuffer[] stringBuffers = new StringBuffer[10];
                         这只是声明了 10个 StringBuffer 的变量 并没有创建对象
                         stringBuffers[i] = new StringBuffer(); 这是给变量创建对象
                         */
                        sb[i] = new StringBuffer();
                        sb[i].append(entry.getKey() + "=" + entry.getValue());
                        sb[i].append("&");
                        System.out.println("sb[param_" + i + "]:" + sb[i]);

                        sb1[i] = new StringBuffer();
                       /* for (int k=0;k<(mapdata[i][j].size());k++){
                            param[k]=sb[i].toString();

                            sb1[k].append(param[k]);

                        }*/
                        System.out.println(sb1[i]);


                      //  for (int k=0;k<(mapdata[i][j].size());k++){
                        /*sb1[k] = new StringBuffer();
                        sb1[k].append(param[i]);
                        System.out.println("sb1[" +k +"]:" + sb1[k].toString());*/


                        }

                }






                  /*  requestUrl[i]=new String();
                    requestUrl[i]=sb[i].toString();
                    System.out.println( requestUrl[i]);*/
            }
           /* requestUrl[i]=sb[i].toString();
            if (requestUrl[i].endsWith("&")) {
                requestUrl[i] = StringUtils.substringBeforeLast( requestUrl[i], "&");
            }
            System.out.println("\n"+ "第" + i + "组请求参数为："+ requestUrl[i]);*/



    }
}
