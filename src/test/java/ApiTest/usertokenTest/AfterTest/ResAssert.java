package ApiTest.usertokenTest.AfterTest;

import JsonHandle.JsonHandle;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by lijing on 2018/6/6.
 * 结果校验
 * 还可以扩充：返回的每个参数和相应数据库表的字段值比对
 */
public class ResAssert {



    public static boolean ExpectResult(JSONObject resJson, String Expectkey, String Expectvalue){
        boolean Result=false;
        String result=resJson.getString("result"); //获取返回结果码
        System.out.println("resultcode is "+ result);
        if(result.equals("200")) {
            //遍历并打印所有的返回结果数据
            JsonHandle.getJson(resJson);
            if (JsonHandle.checkIsExitTheValue(resJson, Expectkey, Expectvalue)) {
                System.out.print("case pass,得到正确的返回值");
                Result = true;
            } else {
                System.out.print("参数返回值错误");
                Result = false;
            }

        } else {
            System.out.print("结果码返回错误。"+ "result is " + result);
            Result = false;
        }

        return Result;
    }

    public static boolean Result(String resultcode){
        boolean Result=false;
        if(resultcode.equals("200")){
            System.out.print("结果码返回正确");
            Result=true;
        }else {
            System.out.print("结果码返回错误");
            Result=false;
        }
        return Result;
    }



}
