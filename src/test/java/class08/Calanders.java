package class08;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Calanders extends CommonMethods {
    public static void main(String[] args) {


        String url = "https://www.aa.com/homePage.do?locale=en_US";
        openBrowserGetURL(url, "chrome");

        var from = driver.findElement(By.xpath("//*[@id='reservationFlightSearchForm.originAirport']"));
        sendText("VLC", from);
        var to = driver.findElement(By.xpath("//*[@id='reservationFlightSearchForm.destinationAirport']"));
        sendText("YYZ", to);

        var passengersSelect = driver.findElement(By.xpath("//*[@id='flightSearchForm.adultOrSeniorPassengerCount']"));
        dropDownSelect(passengersSelect, "3");

        var calendarClick = driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger'][1]"));
        calendarClick.click();

        //driver.findElement(By.xpath("//*[@id='aa-leavingOn']")).sendKeys("08/04/2023");
        //we can use it with this simple line but not everywhere

        //Select the date August 4, 2023

        boolean monthFound = false;
        while (!monthFound) {
            // get the month and check if it is the desired one
            WebElement month = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
            String currentMonth = month.getText();
            if (currentMonth.equals("August")) {
                System.out.println("you are on the right month");
                var allDates = driver.findElements(By.xpath("//table/tbody/tr/td"));
                for (WebElement date : allDates) {
                    String currentDate = date.getText();
                    if (currentDate.equals("4")) {
                        date.click();
                    }
                }
                monthFound = true;
            } else {
            // click next
                WebElement nxtBtn = driver.findElement(By.xpath("(//a[@class='ui-datepicker-next ui-corner-all'])"));
                nxtBtn.click();
            }
        }


    }
}
