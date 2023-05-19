package class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");
        driver.manage().window().maximize();

        // using the WebElement return data type + variable is a better approach + we can reuse it
        WebElement username = driver.findElement(By.id("txtUsername"));
        // and now we can declare variable name use to send the data to the field  + we can reuse it
        username.sendKeys("Admin");
        Thread.sleep(2000);
        username.clear(); // using this method we can clear the field
        Thread.sleep(2000);
        username.sendKeys("Admin");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        Thread.sleep(2000);
        password.clear();
        Thread.sleep(2000);
        password.sendKeys("Hum@nhrm123");
        Thread.sleep(2000);
        WebElement buttonLogin = driver.findElement(By.id("btnLogin"));
        buttonLogin.click();
        WebElement welcomeAdminLink = driver.findElement(By.linkText("Welcome Admin"));
        Thread.sleep(2000);
        String text = welcomeAdminLink.getText(); // return the text of the web element
        System.out.println(text);
        WebElement recruitmentLink = driver.findElement(By.partialLinkText("Recru"));
        recruitmentLink.click();

        // driver.findElements(By.tagName("a")); // if we need to find multiply elements we use .findElements() method


        //driver.quit();


    }
}
