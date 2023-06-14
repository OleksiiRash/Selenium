package class06.homework;

import Utils.CommonMethods;
import org.openqa.selenium.By;

public class Task3_Method_DropDown extends CommonMethods {

    public static void main(String[] args) throws InterruptedException {

        String url = "https://www.facebook.com/";
        openBrowserGetURL(url, "chrome");
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        var clickCreateNewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
        clickCreateNewAccount.click();

        var month = driver.findElement(By.cssSelector("select[id='month']"));
        dropDownSelect(month, "Mar");
        var day = driver.findElement(By.cssSelector("select[id='day']"));
        dropDownSelect(day, "20");
        var year = driver.findElement(By.cssSelector("select[id='year']"));
        dropDownSelect(year, "1989");

    }
}

