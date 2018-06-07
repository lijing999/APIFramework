package ToolTest;

import CommonAPI.EnvInit;
import org.testng.annotations.Test;
import tool.strReplacement;

import java.io.IOException;

/**
 * Created by lijing on 2018/6/6.
 */
public class strReplace {


    public static String strReplace(String apiName){
        String apiName1=" ";
        if (apiName.contains("_")){
            System.out.println("满足条件");
            apiName1=apiName.replace("_","/");
            //System.out.println( apiName.replace("_","/"));
           // System.out.print(apiName1);

        }
        return apiName1;
    }

    @Test
    public void strReplaceTest() throws IOException {
        String apiName="parttime_depts";
        String replacedapiName=strReplacement.strReplace(apiName);
       // System.out.println("\n"+"replacedapiName="+replacedapiName);

        EnvInit.requestUrl("APIurl","parttime_depts");
        //EnvInit.requestUrl("APIurl","userInfoDetail");

    }
}
