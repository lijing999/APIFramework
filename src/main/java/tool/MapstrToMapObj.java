package tool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lijing on 2018/6/4.
 */
public class MapstrToMapObj {

    public static HashMap<String, Object> MapstrToMapObjTest(HashMap<String, String> datas) throws Exception {

        //Converting Map<String,String> to Map<String,Object>
        HashMap<String, Object> MapObj=new HashMap<String, Object>();
        if (datas != null) {
            for (Map.Entry<String, String> entry : datas.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Object objectVal = (Object)value;
                MapObj.put(key, objectVal);
            }
        }
        return MapObj;
    }


}
