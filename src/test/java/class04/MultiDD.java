package class04;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiDD extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {

        String url = "http://practice.syntaxtechs.net/basic-select-dropdown-demo.php";
        openBrowserGetURL(url, "chrome");
        WebElement multiSelect = driver.findElement(By.cssSelector("select[name='States']"));
        Select obj = new Select(multiSelect);
        System.out.println("Multi Select: " + obj.isMultiple());
        obj.selectByVisibleText("California");
        obj.selectByValue("Ohio");
        obj.selectByIndex(2);
        Thread.sleep(2000);
        // we can use as well deselect method
        obj.deselectByIndex(2);


    }
}
