package class04;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class MultiDD extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {

        String url = "http://practice.syntaxtechs.net/basic-select-dropdown-demo.php";
        openBrowserGetURL(url, "chrome");

        //var citiesDrop = driver.findElement(By.id("select-demo"));
        //dropDownSelect(citiesDrop, "Thursday");

        var newMultiSelect = driver.findElement(By.id("multi-select"));
        List<String> attributeValuesToSelect = Arrays.asList("Ohio", "New Jersey");
        multiplyDropDown(newMultiSelect, attributeValuesToSelect, true);


    }
}
