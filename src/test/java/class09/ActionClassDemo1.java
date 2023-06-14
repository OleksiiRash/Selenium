package class09;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo1 extends CommonMethods {
    public static void main(String[] args) {


        String url = "https://www.amazon.com/";
        openBrowserGetURL(url, "chrome");

        var accountsAndLists = driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"));
        // to move the pointer or perform the desired action to the needed element we need to use Action class
        var action = new Actions(driver);
        action.moveToElement(accountsAndLists);




    }
}
