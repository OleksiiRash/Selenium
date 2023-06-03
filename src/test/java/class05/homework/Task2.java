package class05.homework;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Task2 extends CommonMethods {

    public static void main(String[] args) {

        String url = "https://chercher.tech/practice/frames";
        openBrowserGetURL(url, "chrome");

        driver.switchTo().frame("frame1");
        driver.switchTo().frame("frame3");
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        var dropDownSelect = driver.findElement(By.cssSelector("select[id='animals']"));
        var obj = new Select(dropDownSelect);
        obj.selectByValue("babycat");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame1");
        driver.findElement(By.xpath("//input")).sendKeys("I love Java");


    }
}
