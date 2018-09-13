package JsonHandle;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by lijing on 2018/8/29.
 */
public class JsonHandle {

    //遍历json响应
    public static void getJson(JSONObject ResJson) {
        //JSONObject jsonObj = JSONObject.parseObject(Res);
        for (Map.Entry<String, Object> entry : ResJson.entrySet()) {
            if ("JSONArray".equals(entry.getValue().getClass().getSimpleName())) {
                JSONArray jsonArray = ResJson.parseArray(entry.getValue()
                        .toString());
                for (int i = 0; i < jsonArray.size(); i++) {
                    JsonHandle.getJson((JSONObject) jsonArray.get(i));
                }
            } else if ("JSONObject".equals(entry.getValue().getClass().getSimpleName())) {
                JsonHandle.getJson((JSONObject) entry.getValue());
            } else {
                System.out.print(entry.getKey().toString() + " : ");
                System.out.println(entry.getValue().toString());
            }
        }
    }

    //获取某个json对象中某个key的value
    public static boolean getValue(JSONObject ResJson,String theKey) {
        //JSONObject jsonObj = Res.parseObject(abc);
        boolean isExitKey = false;
        for (Map.Entry<String, Object> entry : ResJson.entrySet()) {
            if (entry.getKey().equals(theKey)) {
                String theValues = entry.getValue().toString();
               isExitKey = true;
                // return true;
            } else {
                if ("JSONArray".equals(entry.getValue().getClass()
                        .getSimpleName())) {
                    JSONArray jsonArray = ResJson.parseArray(String.valueOf(entry
                            .getValue()));
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JsonHandle.getValue((JSONObject) jsonArray.get(i),theKey);
                    }
                } else if ("JSONObject".equals(entry.getValue().getClass()
                        .getSimpleName())) {
                    JsonHandle.getValue((JSONObject) entry.getValue(),theKey);

                } else {
                    continue;
                }
            }
        }
        return isExitKey;
    }

    //json响应结果中是否存在某个key值
    public static boolean checkIsExitTheKey(JSONObject ResJson, String theKey) {
        //JSONObject jsonObj = JSON.parseObject(abc);
        boolean isExitTheValue = false;
        for (Map.Entry<String, Object> entry : ResJson.entrySet()) {
            if ("JSONArray".equals(entry.getValue().getClass().getSimpleName())) {
                JSONArray jsonArray = ResJson.parseArray(String.valueOf(entry.getValue()));
                for (int i = 0; i < jsonArray.size(); i++) {
                    JsonHandle.checkIsExitTheKey((JSONObject) jsonArray.get(i), theKey);
                    System.out.println("JSONArray:" + "\n" +(JSONObject) jsonArray.get(i));
                }
            } else if ("JSONObject".equals(entry.getValue().getClass().getSimpleName())) {
                JsonHandle.checkIsExitTheKey((JSONObject) entry.getValue(), theKey);
                System.out.println("JSONObject:" + "\n"+(JSONObject) entry.getValue());
            } else {
                continue;
            }
        }

            return isExitTheValue;
        }

    //json响应结果中是否存在某个key值
    public static boolean checkIsExitTheKey1(JSONObject ResJson, String theKey) {
        //JSONObject jsonObj = JSON.parseObject(abc);
        boolean isExitTheValue = false;
        for (Map.Entry<String, Object> entry : ResJson.entrySet()) {
            if ("JSONArray".equals(entry.getValue().getClass().getSimpleName())) {
                JSONArray jsonArray = ResJson.parseArray(String.valueOf(entry.getValue()));
                for (int i = 0; i < jsonArray.size(); i++) {
                    if (jsonArray.get(i)==theKey){
                        System.out.println("JSONArray:" + "\n" +(JSONObject) jsonArray.get(i));
                        isExitTheValue=true;
                    }else {
                        isExitTheValue=false;
                    }
                    JsonHandle.checkIsExitTheKey1((JSONObject) jsonArray.get(i), theKey);
                }
            } else if ("JSONObject".equals(entry.getValue().getClass().getSimpleName())) {
                JsonHandle.checkIsExitTheKey1((JSONObject) entry.getValue(), theKey);
                System.out.println("JSONObject:" + "\n"+(JSONObject) entry.getValue());
            } else {
                continue;
            }
        }

        return isExitTheValue;
    }


    //json响应结果中是否存在某个key-value键值对
  public static boolean checkIsExitTheValue(JSONObject ResJson, String theKey,String expectValue) {
      //JSONObject jsonObj = JSON.parseObject(abc);
      boolean isExitTheValue = false;
      for (Map.Entry<String, Object> entry : ResJson.entrySet()) {
          if (entry.getKey().equals(theKey)){
              if ("JSONArray".equals(entry.getValue().getClass().getSimpleName())) {
                  JSONArray jsonArray = ResJson.parseArray(String.valueOf(entry.getValue()));
                  for (int i = 0; i < jsonArray.size(); i++) {
                      JsonHandle.checkIsExitTheValue((JSONObject) jsonArray.get(i), theKey, expectValue);
                  }
              } else if ("JSONObject".equals(entry.getValue().getClass().getSimpleName())) {
                  checkIsExitTheValue((JSONObject) entry.getValue(), theKey,expectValue);
              } else {
                  continue;
              }
          }
      }
      return isExitTheValue;
  }



}
