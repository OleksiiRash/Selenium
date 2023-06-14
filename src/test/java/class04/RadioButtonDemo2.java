package class04;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtonDemo2 extends CommonMethods {

    public static void main(String[] args) throws InterruptedException {

        String url = "http://practice.syntaxtechs.net/basic-radiobutton-demo.php";
        openBrowserGetURL(url, "chrome");

        // now we have a list of those age group radio buttons
        List<WebElement> ageGroup = driver.findElements(By.cssSelector("input[name='ageGroup']")); // list if elements not element!

        String rOption2 = "5 - 15";

        for (WebElement btn : ageGroup) {
            String value = btn.getAttribute("value");
            if (value.equals(rOption2)) {
                btn.click(); // if I need to check all I just leave the btn.click and loop wil be executed
                break;
            }
        }


    }
}
