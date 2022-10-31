package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.SimpleDateFormat;
// All these imports are import classes

public class BasePage {

    protected static WebDriver driver;
    // created driver obj for WebDriver to use it for WebDriver to perform functions on webpage.

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        //setProperty is used to locate the Chrome web browser location in order to use Chrome browser later.

        driver= new ChromeDriver();
        // used to open the Chrome browser.

        driver.manage().window().maximize();
        //.maximize(); to keep the window in fullscreen

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        //SimpleDateFormat will give the current date and time while execution in the given pattern.

        driver.get("https://demo.nopcommerce.com/");
        // .get("URL"); to go to that link in the opened browser window.

        driver.findElement(By.className("ico-register")).click();
        //.findElement(By.className("locator")) will locate the locator by class-name and .click(); will perform the click action on the given locator

        driver.findElement(By.id("FirstName")).sendKeys("Naman");
        //.findElement(By.id("Locator")) will find the locator by unique id and .sendKeys("data"); will auto input the added data in the locator.

        driver.findElement(By.id("LastName")).sendKeys("Upadhyay");
        driver.findElement(By.id("Email")).sendKeys("namanfusion123"+timeStamp+"@gmail.com");
        //in order to test this a certain feature multiple times such as register, we need to have a unique mail id every time so with a simple concatenation of + timeStamp ~ the object we created for SimpleDateFormat will give unique mail id every time.

        driver.findElement(By.id("Password")).sendKeys("password123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("password123");
        driver.findElement(By.id("register-button")).click();

        String Msg = driver.findElement(By.className("result")).getText();
        // in order to print an output given by the webpage we stored the value in 'String' and stored the value by className locator. And .getText(); is used to receive the text displayed on the screen.
        System.out.println(Msg);
        // will print the data stored in 'Msg'.

        driver.quit();
        //.quit(); used to close the browser.

    }

}