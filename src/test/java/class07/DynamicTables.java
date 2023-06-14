package class07;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.Constants;
import org.openqa.selenium.By;


public class DynamicTables extends CommonMethods {
    public static void main(String[] args) {

        ConfigReader.getProperties(Constants.CONFIG_READER_PATH);
        String url = ConfigReader.getProperty("URL");

        openBrowserGetURL(url, "chrome");

        var username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys(ConfigReader.getProperty("userName"));
        var pass = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        pass.sendKeys(ConfigReader.getProperty("password"));
        var submit = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        submit.click();

        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();


        //print the row number of the row that has the id 55822A
        var tableRows = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td[2]")); // cell number in the column

        for (int i = 0; i < tableRows.size(); i++) {
            var textElement = tableRows.get(i).getText();
            if (textElement.equals("55822A")) {
                System.out.println("The row number is " + (i + 1)); // indexing starts with 0 but the table nums starts from 1,2,3... etc.
                //var row = driver.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]"));
                //System.out.println(row.getText());
                System.out.println(textElement);
            }

        }


        closeBrowser();

    }
}
