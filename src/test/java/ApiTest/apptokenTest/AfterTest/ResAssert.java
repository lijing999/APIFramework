package ApiTest.apptokenTest.AfterTest;

/**
 * Created by lijing on 2018/6/6.
 * 结果校验：这儿值校验了返回的结果码
 * 还可以扩充：返回的每个参数和相应数据库表的字段值比对
 */
public class ResAssert {

    public static boolean Result(String resultcode){
        if(resultcode.equals("200")){
            System.out.print("case pass");
            return true;
        }else{
            System.out.print("case fail");
            return false;
        }
    }

}
