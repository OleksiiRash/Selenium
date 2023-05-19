package class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class LocatorTagName {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        // get all the links from amazon.com and print them on the console
        // in order to return the correct data type for multiply elements we need to use the List<WebElement>
        List<WebElement> findAllLinks = driver.findElements(By.tagName("a"));

        for (WebElement findLInks : findAllLinks) {
            String link = findLInks.getAttribute("href");
            System.out.println(link);
        }

        driver.quit();


    }
}
