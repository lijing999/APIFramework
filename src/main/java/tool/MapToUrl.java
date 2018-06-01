package tool;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lijing on 2018/6/1.
 */
public class MapToUrl {

    public static String mapTourl(HashMap<String, String> data){
        if (data == null) {
            return "无输入參數" ;
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
        return  requestUrl1;
    }
}
