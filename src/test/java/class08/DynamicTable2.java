package class08;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.Constants;
import org.openqa.selenium.By;

public class DynamicTable2 extends CommonMethods {
    public static void main(String[] args) {

        ConfigReader.getProperties(Constants.CONFIG_READER_PATH);

        String url = ConfigReader.getProperty("URL2");
        openBrowserGetURL(url, "chrome");

        var username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys(ConfigReader.getProperty("userName"));
        var pass = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        pass.sendKeys(ConfigReader.getProperty("password"));
        var submit = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        submit.click();

        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
        var rowId = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));

        for (int i = 0; i < rowId.size(); i++) {
            var elementId = rowId.get(i).getText();
            if (elementId.equals("53502A")) {
                System.out.println("checkbox number is " + (i + 1) + " and the element is " + elementId);
                var rowNum = i + 1;
                // we add in the xPath the i element in order to find the exact element
                driver.findElement(By.xpath("//table/tbody/tr[" + rowNum + "]/td[1]")).click();
            }
        }

        closeBrowser();


    }
}
