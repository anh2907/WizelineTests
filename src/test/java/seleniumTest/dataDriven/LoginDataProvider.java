package seleniumTest.dataDriven;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name = "Step1")
    public Object[][] getLoginData(){
        //Object[][] data ={{"sunflower837@yahoo.com", "Kms@2018"}};
        ReadExcelFile config = new ReadExcelFile("C:\\Users\\anhntnguyen\\IdeaProjects\\WizeLineAutoTests\\src\\test\\testData\\WizeLineTestData.xlsx");
        int rows = config.getRowCount("Step1");
        Object[][] data = new Object[rows][3];
        for(int i=0;i<rows;i++)
        {
            data[i][0] = config.getData("ValidLoginData", i, 0);
            data[i][1] = config.getData("ValidLoginData", i, 1);
            data[i][2] = config.getData("ValidLoginData", i, 2);
        }
        return data;
    }

}
