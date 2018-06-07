package ToolTest;

import org.testng.annotations.Test;
import demo.ExcelNameData_map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lijing on 2018/5/31.
 */
public class ExcelmapTest {

    /**
     * 测试类：根据excel路径和页签名获取参数
     */
    @Test
    public void excelMapTest(){
        ExcelNameData_map excelCase=new ExcelNameData_map();
        String file="E:\\test.xlsx";
        //String file="E:\\login.xlsx";
        HashMap<String, String>[][] mapdata = excelCase.testData(file, "pupdata");

        System.out.println("通过Map.entrySet遍历key和value");
        for (int i=0;i<mapdata.length;i++){
            System.out.println(mapdata[i].length);
            for (int j=0;j<mapdata[i].length;j++){
                /**
                 * Map.Entry描述在一个Map中的一个元素（键/值对）。
                 * Map.entrySet 是map中所有的键值对
                 */
                for (Map.Entry<String, String> entry:mapdata[i][j].entrySet()) {
                    System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                }
            }
        }

    }



}
