package class04.homework;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class Task2 extends CommonMethods {

    public static void main(String[] args) throws InterruptedException {

/*
hw2:
goto facebook.com
click on create account
and select your date of birth using select class
*/

        String url = "https://www.facebook.com/";
        openBrowserGetURL(url, "chrome");
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        WebElement clickCreateNewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
        clickCreateNewAccount.click();
        Thread.sleep(2000);

        List<WebElement> dayOfWeek = driver.findElements(By.cssSelector("select[id='month'], select[id='day'], select[id='year']"));
        List<String> valuesToSelect = Arrays.asList("3", "20", "1989");

        for (int i = 0; i < dayOfWeek.size(); i++) {
            Select obj = new Select(dayOfWeek.get(i));
            obj.selectByValue(valuesToSelect.get(i));
            Thread.sleep(1000);
        }

        driver.quit();


    }
}
