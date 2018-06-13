package tool;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.*;

/**
 * Created by lijing on 2018/6/4.
 * post请求参数，map参数转为list类型
 */
public class MapToList {

    public static List<NameValuePair> mapToList(HashMap<String, String> Mapdatas) {
        List<NameValuePair> list = new ArrayList<NameValuePair>();

        for (Map.Entry<String, String> entry : Mapdatas.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            list.add(new BasicNameValuePair(key, value));
        }

        for (NameValuePair str : list) {            //也可以改写for(int i=0;i<list.size();i++)这种形式
            System.out.println(str);
        }
        return list;
    }
}
