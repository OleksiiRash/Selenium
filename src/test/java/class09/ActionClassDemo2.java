package class09;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo2 extends CommonMethods {
    public static void main(String[] args) {


        String url = "https://jqueryui.com/droppable/";
        openBrowserGetURL(url, "chrome");

        driver.switchTo().frame(0);

        var dragElement = driver.findElement(By.id("draggable"));
        var dropElement = driver.findElement(By.id("droppable"));

        var action = new Actions(driver);
        action.dragAndDrop(dragElement, dropElement).perform();


    }
}
