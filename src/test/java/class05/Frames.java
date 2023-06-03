package class05;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Frames extends CommonMethods {
    public static void main(String[] args) {

        /*
        print animal on screen
        and select baby cat from the dropdown
         */

        String url = "https://chercher.tech/practice/frames";
        openBrowserGetURL(url, "chrome");

        driver.switchTo().frame("frame2");
        var dropDownHeadline = driver.findElement(By.xpath("//b[text()='Animals :']"));

        System.out.println(dropDownHeadline.getText());
        System.out.println("-----------------");

        var animalDropDown = driver.findElement(By.cssSelector("select[id='animals']"));
        System.out.println(animalDropDown.getText());

        Select obj = new Select(animalDropDown);
        obj.selectByValue("babycat");

        driver.switchTo().defaultContent(); // switch the focus on the main window
        driver.switchTo().frame("frame1");
        driver.findElement(By.xpath("//input")).sendKeys("Not a Friendly Topic");

        driver.switchTo().frame("frame3");
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();

        


    }
}
