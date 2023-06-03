package class04.homework;

import Utlis.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class Task1 extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {

/*
HW1:
goto: http://practice.syntaxtechs.net/basic-select-dropdown-demo.php
select, tuesday, thursday and friday one by one
*/

        String url = "http://practice.syntaxtechs.net/basic-select-dropdown-demo.php";
        openBrowserGetURL(url, "chrome");
        WebElement dayOfWeek = driver.findElement(By.cssSelector("select[id='select-demo']"));
        Select obj = new Select(dayOfWeek);
        var valuesToSelect = Arrays.asList("Tuesday", "Thursday", "Friday");
        for (var value : valuesToSelect) {
            obj.selectByValue(value);
        }

        driver.quit();

    }
}
