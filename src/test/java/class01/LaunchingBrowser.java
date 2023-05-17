package class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchingBrowser {

    public static void main(String[] args) throws InterruptedException {


        // we call the prebuilt method called WebDriver
        // second driver it is just a variable, and we can use our own
        // use .get ("") to navigate to needed link
        // .get will wait for the full loading page vs .navigate not but keep the history

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize(); // maximize the window command, full screen
        String currentURL = driver.getCurrentUrl(); // we this method command we can get the current URl
        System.out.println("URl of the website is " + currentURL);

        String title = driver.getTitle();
        System.out.println("Title of the page is " + title);

        // add some wait time - we need to place before closing the browser - it is up to us where we need to slow down
        Thread.sleep(5000);

        driver.quit(); // automation to close the browser we can use as well .close()


    }
}
