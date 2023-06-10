package class07.homework;

import Utlis.CommonMethods;
import Utlis.ConfigReader;
import Utlis.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task1 extends CommonMethods {
    public static void main(String[] args) {

/*
goto http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
login
click on PIM

from the table choose any ID
and print out the row number of that id
please make sure that ur code is dynamic enough to cater if another row gets deleted, it still prints the row correctly
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


        //print the row number of the row that has the id 55822A
        var tableRows = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr/td[2]"));

        for (int i = 0; i < tableRows.size(); i++) {
            var textElement = tableRows.get(i).getText();
            if (textElement.equals("55822A")) {
                System.out.println("The row number is " + (i + 1));
                System.out.println(textElement);
            }

        }

        closeBrowser();

    }
}
