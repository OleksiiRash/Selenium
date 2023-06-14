package class08.homework;

import Utils.CommonMethods;
import org.openqa.selenium.By;

public class Task1_GoogleFlights extends CommonMethods {
    public static void main(String[] args) {


/*
goto https://www.google.com/travel/flights
fill all the forms and press the search button
*/


        var url = "https://www.google.com/travel/flights";
        openBrowserGetURL(url, "chrome");

        driver.findElement(By.xpath("//span[contains(text(), 'Accept all')]")).click();
        driver.findElement(By.xpath("//span[@class='snByac'][normalize-space()='Round trip']")).click();
        //one way trip
        driver.findElement(By.xpath("(//li[@class='uT1UOd'][@data-value='2'])[1]")).click();
        driver.findElement(By.xpath("//button[@jsname='LgbsSe'][@aria-label='1 passenger']")).click();

        var adult = driver.findElement(By.xpath("//*[@id='i6-1']/div/span[3]/button"));
        var child = driver.findElement(By.xpath("(//*[name()='svg'][@class='g2ZhCc NMm5M'])[4]"));

        // 4 adults and 2 child
        int adultCount = 0;
        int childCount = 0;

        for (int i = 0; i < 5; i++) {
            if (adultCount < 3) { // + 1 that is already selected
                adult.click();
                adultCount++;
            }

            if (childCount < 2) {
                child.click();
                childCount++;
            }
        }

        driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'][normalize-space()='Done'])[1]")).click();
        driver.findElement(By.xpath("//button[@aria-label='Economy, Change seating class.']")).click();
        driver.findElement(By.xpath("//li[normalize-space()='Premium economy']")).click();


        var from = driver.findElement(By.xpath("(//input[@role='combobox'])[1]"));
        sendText("CDG", from);
        driver.findElement(By.xpath("(//div[@class='w1ZvBc'])[1]")).click();

        driver.switchTo().defaultContent(); // switch the focus on the main window

        var to = driver.findElement(By.xpath("(//input[@placeholder='Where to?'])[1]"));
        sendText("YYZ", to);
        driver.findElement(By.xpath("(//div[@class='zsRT0d'])[1]")).click();

        driver.findElement(By.xpath("(//input[@placeholder='Departure'])[1]")).click();

        var found = false;
        while (!found) {
            //var month = driver.findElement(By.xpath("//div[@class='BgYkof B5dqIf qZwLKe']")).getText();

            var date = driver.findElements(By.xpath("//div[@class='eoY5cb CylAxb sLG56c yCya5']"));
            for (var allDate : date) {
                var selectDate = allDate.getAttribute("aria-label");
                if (selectDate.contains("Aug 4")) {
                    allDate.click();

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'][normalize-space()='Done'])[2]")).click();
                    found = true;
                    break;

                }
            }
            if (!found) {
                // click next
                var nxtBtn = driver.findElement(By.xpath("//button[@aria-label='Next']//div[@class='VfPpkd-RLmnJb']"));
                nxtBtn.click();
            }
        }

        var searchBtn = driver.findElement(By.xpath("//span[normalize-space()='Search']"));
        searchBtn.click();

        //closeBrowser();

    }
}

