package ToolTest;

import CommonAPI.EnvInit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tool.MapToList;

import java.util.HashMap;

/**
 * Created by lijing on 2018/6/4.
 */
public class MapToListTest {
    @DataProvider(name="testData")
    public Object[][] data() throws Exception {
        Object[][] testdata= EnvInit.EnvInitTest("E:\\API.xlsx","authorize");
        return testdata;
    }

    @Test(dataProvider = "testData")
    public void MapTolistTest(HashMap<String, String> Mapdatas){
        MapToList.mapToList(Mapdatas);
    }

}
