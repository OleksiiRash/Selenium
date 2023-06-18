package class07;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Tables extends CommonMethods {

    public static void main(String[] args) {

        String url = "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";
        openBrowserGetURL(url, "chrome");
        driver.findElement(By.xpath("//*[@id='ez-accept-all']")).click();

        //***************table level access*********************
        var table = driver.findElement(By.xpath("//*[@id='customers']"));
        System.out.println(table.getText());

        System.out.println("-----------Checking if Google exist in the whole Table------------");

        Assert.assertTrue(table.getText().contains("Google"), "False");
        System.out.println("True");

        System.out.println("---------------------------");

        //****************row level access of table*************
        var tableRows = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr"));
        for (var t : tableRows) {
            var rowText = t.getText();
            if (rowText.contains("Google")) {
                System.out.println(rowText);
            }
        }

        System.out.println("------------------");
        var thirdRow = tableRows.get(2).getText();
        System.out.println(thirdRow);

        System.out.println("---------------------------");

        var thirdRowNew = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[3]"));
        System.out.println(thirdRowNew.getText());

        //****************separate elements of table*************
        System.out.println("---------------------------");
        var tableElements = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr/td"));
        for (var t : tableElements) {
            System.out.println(t.getText());
        }


        closeBrowser();

    }
}
