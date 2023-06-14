package class09;

import Utlis.CommonMethods;
import org.openqa.selenium.By;

public class FileUpload extends CommonMethods {
    public static void main(String[] args) {


        String url = "https://the-internet.herokuapp.com/upload";
        openBrowserGetURL(url, "chrome");

        var fileUploadBtn = driver.findElement(By.xpath("//input[@id='file-upload']"));
        fileUploadBtn.sendKeys("C:\\Users\\Alexey\\Desktop\\Java.txt");


    }
}
