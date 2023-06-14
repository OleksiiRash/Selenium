package class09;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class KEYSDemo extends CommonMethods {
    public static void main(String[] args) {

        String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
        openBrowserGetURL(url, "chrome");

        WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
        // we can use Keys. methods to execute many operations in order to get same result instead of send keys directly
        userName.sendKeys("Tester", Keys.TAB);

        // locate the password text Box
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test", Keys.ENTER);

    }
}


