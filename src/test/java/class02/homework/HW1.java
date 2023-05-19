package class02.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HW1 {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        WebElement clickCreateNewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
        clickCreateNewAccount.click();
        Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First name']"));
        firstName.sendKeys("Oleksii");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Rashevskyi");
        WebElement emailOrPhone = driver.findElement(By.xpath("//input[contains(@name,'reg_email')]"));
        emailOrPhone.sendKeys("+3485478745");
        WebElement password = driver.findElement(By.xpath("//input[contains(@name,'reg_passwd')]"));
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
