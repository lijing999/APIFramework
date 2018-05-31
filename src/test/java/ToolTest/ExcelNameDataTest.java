package ToolTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requests.GetRequest;
import tool.ExcelNameData;

import java.util.HashMap;

/**
 * Created by lijing on 2018/5/29.
 */
public class ExcelNameDataTest {
    /**
     * testng使用数据
     */
    @DataProvider(name="testData")
    public Object[][]data(){
        ExcelNameData excelCase=new ExcelNameData();
        String file="E:\\test.xlsx";
        //String file="E:\\login.xlsx";
        return excelCase.testData(file,"ssodata");
    }

    @Test(dataProvider = "testData")
    public void testCase(HashMap<String, String> data){
       /*String ClientId=data.get("client_id");
       System.out.println("client_id:" + ClientId);
       String ClientSecret=data.get("client_secret");
       System.out.println("client_secret:" + ClientSecret);
        String UserName=data.get("username");
        System.out.println("username:"+UserName);
        String Pwd=data.get("password");
        System.out.println("password:"+Pwd);*/


        String UserName=data.get("username");
        System.out.println("username:"+UserName);
        String Pwd=data.get("password");
        System.out.println("password:"+Pwd);


    }

}
