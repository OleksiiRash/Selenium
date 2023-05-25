package class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathDemo {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.xpath("//*[@id='txtUsername']"));
        Thread.sleep(2000);
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//*[@id='txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.xpath("//*[contains(@id, 'btnLogin')]"));
        loginButton.click();
        WebElement pim = driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']"));
        pim.click();






    }
}
