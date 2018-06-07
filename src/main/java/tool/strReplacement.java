package tool;

/**
 * Created by lijing on 2018/6/6.
 * 接口名称中带/字符，sheetname不支持 用_代替
 * 但是接口请求的时候要替换回来
 */
public class strReplacement {
    public static String strReplace(String apiName){

        String replacedapiName="";

        if (apiName.contains("_")){

            System.out.println("满足条件");
            replacedapiName=apiName.replace("_","/");
           // System.out.println( apiName.replace("_","/"));
            System.out.print(replacedapiName);

        }
        return replacedapiName;

    }
}
