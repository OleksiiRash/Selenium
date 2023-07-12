package class04;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class CheckBoxDemo extends CommonMethods {

    public static void main(String[] args) {

        String url = "http://practice.syntaxtechs.net/basic-checkbox-demo.php";
        openBrowserGetURL(url, "chrome");
        //WebElement isAgeSelected = driver.findElement(By.cssSelector("input[id='isAgeSelected']"));
        //checkBox(isAgeSelected);

        List<WebElement> cb1Group = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        List<String> checkBoxValues = Arrays.asList("Option-2", "Option-4");
        checkBoxMultiple(cb1Group, checkBoxValues, false);


    }
}
