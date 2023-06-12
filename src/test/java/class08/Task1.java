package class08;

import Utlis.CommonMethods;
import Utlis.ConfigReader;
import Utlis.Constants;
import org.openqa.selenium.By;

public class Task1 extends CommonMethods {
    public static void main(String[] args) {

        /*
        go to this page: http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
        then go to the PIM and select Employee List
        Check the checkbox that is associated with the ID 55762A
         */

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

        var rowID = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td[2]"));
        var rowCheckbox = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td[1]"));

        var iNew = 0;
        var checkBoxElement1 = false;

        for (int i = 0; i < rowID.size(); i++) {
            for (int j = 0; j < rowCheckbox.size(); j++) {
                var idElement = rowID.get(i).getText();
                var checkBoxElement = rowCheckbox.get(j).isSelected();
                if (idElement.equals("55762A")) {
                    iNew = i + 1;
                    checkBoxElement1 = checkBoxElement;
                }
            }
        }
        
        System.out.println("The row number is " + iNew + " and the checkbox is " + checkBoxElement1);


    }
}
