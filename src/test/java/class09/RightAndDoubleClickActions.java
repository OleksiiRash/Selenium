package class09;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RightAndDoubleClickActions extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {

        String url = "http://demo.guru99.com/test/simple_context_menu.html";
        openBrowserGetURL(url, "chrome");

        var rightClickBtn = driver.findElement(By.xpath("//span[text()='right click me']"));
        var action = new Actions(driver);
        action.contextClick(rightClickBtn).perform();
        var edit = driver.findElement(By.xpath("//span[normalize-space()='Edit']"));
        action.click(edit).perform();

        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        driver.switchTo().frame(3);

        var acceptCookie = driver.findElement(By.xpath("//button[@id='save']"));
        action.click(acceptCookie).perform();

        driver.switchTo().defaultContent();

        var doubleClick = driver.findElement(By.xpath("//button[contains(text(),'Double-Click')]"));
        action.doubleClick(doubleClick).perform();
        driver.switchTo().alert().accept();



    }
}
