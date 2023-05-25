package class03;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSSdemo extends CommonMethods {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        WebElement createAccount = driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));
        createAccount.click();
        Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("Oleksii");
        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("Rashevskyi");
        WebElement emailOrPhone = driver.findElement(By.cssSelector("input[name='reg_email__']"));
        emailOrPhone.sendKeys("+3485478745");
        WebElement password = driver.findElement(By.cssSelector("input[id='password_step_input']"));
        password.sendKeys("1234789pass$");

        driver.findElement(By.xpath("//select[@name='birthday_month']")).sendKeys("Mar");
        driver.findElement(By.xpath("//select[@name='birthday_day']")).sendKeys("20");
        driver.findElement(By.xpath("//select[@name='birthday_year']")).sendKeys("1989");
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[contains(@class, '8idr')]")).click();
        Thread.sleep(2000);
        driver.quit();







    }
}
