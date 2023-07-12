package class09.homework;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Task1_Search_ByName extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {

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
        var action = new Actions(driver);
        var searchByName = driver.findElement(By.id("empsearch_employee_name_empName"));
        action.moveToElement(searchByName).perform();
        Thread.sleep(2000);
        searchByName.clear();
        Thread.sleep(2000);
        action.click(searchByName).perform();
        Thread.sleep(2000);
        searchByName.clear();
        sendText("Asli S", searchByName);
        var selectNameDropDown = driver.findElement(By.xpath("//div[@class='ac_results']"));
        implicitWait(20);
        action.click(selectNameDropDown).perform();





    }
}
