package class06;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ImplicitWait extends CommonMethods {
    public static void main(String[] args) {

        String url = "https://www.facebook.com/";
        openBrowserGetURL(url, "chrome");
        //declaring the implicit wait in the start as it is a global wait,
        // and we want it to be implemented on all the webElements
        //important to define always as we are going to start the code / can be used together with explicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // important thing instead of Thread.sleep

        driver.findElement(By.cssSelector("button[data-testid='cookie-policy-manage-dialog-accept-button']")).click();
        var createAccountBtn = driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
        createAccountBtn.click();

        var firstName = driver.findElement(By.xpath("//input[@placeholder='First name']"));
        sendText("Oleksii", firstName);


    }
}