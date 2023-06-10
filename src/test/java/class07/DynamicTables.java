package class07;

import Utlis.CommonMethods;
import Utlis.ConfigReader;
import Utlis.Constants;
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
        var tableRows = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));

        for (int i = 0; i < tableRows.size(); i++) {
            var textElement = tableRows.get(i).getText();
            if (textElement.contains("55822A")) {
                System.out.println("The row number is " + (i + 1)); // indexing starts with 0 but the table nums starts from 1,2,3... etc.
                System.out.println(textElement);
            }

        }


        closeBrowser();

    }
}
