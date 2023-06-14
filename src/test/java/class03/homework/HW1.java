package class03.homework;

import Utils.CommonMethods;
import org.openqa.selenium.By;

public class HW1 extends CommonMethods {

    public static void main(String[] args) throws InterruptedException {

        HW1.openBrowserGetURL("http://practice.syntaxtechs.net/input-form-demo.php", "firefox");
        driver.findElement(By.cssSelector("input[data-bv-field='first_name']")).sendKeys("Oleksii");
        driver.findElement(By.cssSelector("input[data-bv-field='last_name']")).sendKeys("Rashevskyi");
        driver.findElement(By.cssSelector("input[data-bv-field='email']")).sendKeys("alexey.rashevskyi@gmail.com");
        driver.findElement(By.cssSelector("input[data-bv-field='phone']")).sendKeys("+1454457788");
        driver.findElement(By.cssSelector("input[data-bv-field='address']")).sendKeys("162 White Long Beach, CA 90805");
        driver.findElement(By.cssSelector("input[data-bv-field='city']")).sendKeys("Los Angeles");
        driver.findElement(By.xpath("//select[@data-bv-field='state']")).sendKeys("California");
        driver.findElement(By.cssSelector("input[data-bv-field='city']")).sendKeys("Los Angeles");
        driver.findElement(By.cssSelector("input[data-bv-field='zip']")).sendKeys("90805");
        driver.findElement(By.cssSelector("input[name='website']")).sendKeys("https://www.syntaxtechs.com/");
        driver.findElement(By.cssSelector("input[value='yes']")).click();
        driver.findElement(By.cssSelector("textarea[data-bv-field='comment']")).sendKeys("I like Java");
        driver.findElement(By.cssSelector("button[class='btn btn-default']")).click();
        Thread.sleep(2000);
        HW1.closeBrowser();


    }
}
