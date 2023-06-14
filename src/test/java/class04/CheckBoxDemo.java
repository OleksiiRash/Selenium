package class04;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxDemo extends CommonMethods {

    public static void main(String[] args) {

        String url = "http://practice.syntaxtechs.net/basic-checkbox-demo.php";
        openBrowserGetURL(url, "chrome");
        WebElement isAgeSelected = driver.findElement(By.cssSelector("input[id='isAgeSelected']"));
        //isAgeSelected.click();
        if (!isAgeSelected.isSelected()) {
            isAgeSelected.click();
            System.out.println("The checkbox was not selected");
        } else {
            System.out.println("checkbox was selected");
        }

        List<WebElement> cb1Group = driver.findElements(By.cssSelector("input[class='cb1-element']"));
        for (WebElement cb1 : cb1Group) {
            String checkbox2 = "Option-2";
            String value = cb1.getAttribute("value");
            if (value.equals(checkbox2))
                cb1.click(); // if we just need to click on all we leave only cb1.click()
            break;
        }


    }
}
