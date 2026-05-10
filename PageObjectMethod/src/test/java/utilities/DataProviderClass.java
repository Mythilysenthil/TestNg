package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "loginData")
    public Object[][] loginData()throws IOException {

        String path =System.getProperty("user.dir")+ "/src/test/resources/testdata/LoginData.xlsx";
        System.out.println(path);
        return ExcelUtility.getExcelData(path,"LoginData");
    }
}