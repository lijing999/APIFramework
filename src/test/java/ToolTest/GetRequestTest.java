package ToolTest;

import org.testng.annotations.DataProvider;
import demo.GetRequest;
import tool.ExcelNameData;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by lijing on 2018/5/30.
 */
public class GetRequestTest {

    @DataProvider(name = "testdata")
    public static Object[][]data(){
        ExcelNameData excelCase=new ExcelNameData();
        String file="E:\\API.xlsx";
        //String file="E:\\login.xlsx";
        return excelCase.testData(file,"apptoken");
    }

    @org.testng.annotations.Test(dataProvider= "testdata")
    public void getRequest(HashMap<String, String> data) throws IOException {
         String code=GetRequest.getRequest("SSOurl","apptoken",data);

    }
}
