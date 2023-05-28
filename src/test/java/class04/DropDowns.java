package class04;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDowns extends CommonMethods {

    public static void main(String[] args) throws InterruptedException {

        String url = "https://www.facebook.com/";
        openBrowserGetURL(url, "chrome");
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        WebElement clickCreateNewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
        clickCreateNewAccount.click();
        Thread.sleep(2000);
        WebElement month = driver.findElement(By.cssSelector("select[id='month']"));
        Select obj = new Select(month);
        obj.selectByVisibleText("Mar");
        Thread.sleep(2000);
        obj.selectByValue("4");
        Thread.sleep(2000);
        obj.selectByIndex(0);




    }
}
