package class06;

import Utlis.CommonMethods;
import org.openqa.selenium.By;

import java.util.Set;

public class WindowHandles extends CommonMethods {

    public static void main(String[] args) {

        String url = "https://accounts.google.com/signup/v2/createaccount?flowName=GlifWebSignIn&flowEntry=SignUp&hl=en";
        openBrowserGetURL(url, "chrome");
        // click on the help button and privacy button
        var helpButton = driver.findElement(By.xpath("//a[text()='Help']"));
        helpButton.click();
        var privacyButton = driver.findElement(By.xpath("//a[text()='Privacy']"));
        privacyButton.click();

        // var mainPageHandle = driver.getWindowHandle();
        // System.out.println("Main Page Handle is: " + mainPageHandle);
        // System.out.println("Main Page Headline is: " + driver.getTitle());

        var allWindowHandles = driver.getWindowHandles();
        for (var a : allWindowHandles) {
            driver.switchTo().window(a);
            var allTitles = driver.getTitle();
            if (allTitles.equalsIgnoreCase("Google Account Help")) {
                break;
            }
           // System.out.println(a + " - " + allTitles);
        }

        System.out.println("The current focus of the web-driver is here " + driver.getTitle());

    }
}
