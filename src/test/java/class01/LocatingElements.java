package class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LocatingElements {
    public static void main(String[] args) {

        //instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        WebDriver driver = new ChromeDriver(options);
        //navigate to the facebook
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        // send some text to the email field
        driver.findElement(By.id("email")).sendKeys("alexey.rashevskyi@gmail.com");
        // send some text to the password field
        driver.findElement(By.name("pass")).sendKeys("password123");

        var url = driver.getCurrentUrl();
        System.out.println("The URl of the page is " + url);

        var actualTitle = driver.getTitle();
        var expectedTitle = "Facebook - log in or sign up";

        System.out.println("The Title of the page is " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "not correct title");
        System.out.println("correct title");

        driver.quit();

    }
}
