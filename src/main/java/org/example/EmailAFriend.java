package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// all the import classes for web drivers and selenium.

import java.text.SimpleDateFormat;

public class EmailAFriend {

    protected static WebDriver driver;
    // created driver obj for WebDriver to use it for WebDriver to perform functions on webpage.

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/java/Drivers/chromedriver.exe");
        //setProperty is used to locate the Chrome web browser location in order to use Chrome browser.

        driver = new ChromeDriver();
        //used to open the Chrome browser.

        driver.manage().window().maximize();
        //.maximize(); to keep the window in fullscreen

        driver.get("https://demo.nopcommerce.com/");
        //.get("URL"); to go to that link in the opened browser window.

        driver.findElement(By.xpath("//img[@src=\"https://demo.nopcommerce.com/images/thumbs/0000024_apple-macbook-pro-13-inch_415.jpeg\"]")).click();
        //.findElement(By.xpath("locator")); to locate the locator 'Apple Macbook pro 13 inch' via xpath. And .click(); is used to perform click action on the given locator.

        driver.findElement(By.xpath("//button[@class='button-2 email-a-friend-button']")).click();
        //.findElement(By.xpath("locator")); to locate the locator 'email a friend button' via xpath. And .click(); is used to perform click action on the given locator.

        driver.findElement(By.id("FriendEmail")).sendKeys("Chirag@gmail.com");
        //.findElement(By.id("Locator")) will find the locator by unique id("FriendEmail") and .sendKeys("Chirag@gmail.com"); will auto input the added data in the locator.

        driver.findElement(By.id("YourEmailAddress")).sendKeys("Naman@gmail.com");

        driver.findElement(By.id("PersonalMessage")).sendKeys("You need to checkout this awesome new apple product!!");

        driver.findElement(By.name("send-email")).click();

        String Success = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']//li")).getText();
        //stored the locator value in a 'String' which is "Success" and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'

        System.out.println(Success);
        //to print the data in the string "Success"

        driver.quit();
        //To exit the browser.

    }

}