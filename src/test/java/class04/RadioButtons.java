package class04;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RadioButtons extends CommonMethods {

    public static void main(String[] args) {

        String url = "http://practice.syntaxtechs.net/basic-radiobutton-demo.php";
        openBrowserGetURL(url, "chrome");
        WebElement rMale = driver.findElement(By.cssSelector("input[value='Male'][name='optradio']"));
        rMale.click();

        System.out.println("Male Radio Button is selected: " + rMale.isSelected());
        System.out.println("Male Radio Button is displayed: " + rMale.isDisplayed());
        System.out.println("Male Radio Button is enabled: " + rMale.isEnabled());

        WebElement rFemale = driver.findElement(By.cssSelector("input[value='Female'][name='optradio']"));
        rFemale.click();

        System.out.println("Male Radio Button is selected: " + rMale.isSelected());






    }
}
