package class08;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.Constants;
import org.openqa.selenium.By;

public class DynamicTable3 extends CommonMethods {
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

        // find the element of the second pagination page and click on the checkbox associated with this element


        boolean found = false;
        var nextBtn = driver.findElement(By.xpath("//a[text()='Next']"));

        while (!found) {
            // if we are working with page refreshing important to hae the list inside the loop in order to repeat searching again
            // steal element exception if occur we need to place inside the loop
            var allIds = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
            for (int i = 0; i < allIds.size(); i++) {
                var id = allIds.get(i).getText();
                if (id.equals("54126A")) {
                    System.out.println("click on the check box on row number " + (i + 1));
                    var checkBox = driver.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]"));
                    checkBox.click();
                    found = true;
                    break;
                }
            }

            if (!found) {
                nextBtn.click();
            }
        }

        closeBrowser();


    }
}
