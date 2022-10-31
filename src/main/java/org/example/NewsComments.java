package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// all the import classes for web drivers and selenium.

public class NewsComments {

    protected static WebDriver driver;
    // created driver obj for WebDriver to use it for WebDriver to perform functions on webpage.

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/java/Drivers/chromedriver.exe");
        //setProperty is used to locate the Chrome web browser location in order to use Chrome browser later.

        driver = new ChromeDriver();
        // used to open the Chrome browser.

        driver.manage().window().maximize();
        //.maximize(); to keep the window in fullscreen

        driver.get("https://demo.nopcommerce.com/");
        // .get("URL"); to go to that link in the opened browser window.

        driver.findElement(By.xpath("//div[@class='buttons']//a[@href=\"/nopcommerce-new-release\"]")).click();
        //.findElement(By.xpath("locator")); to locate the locator computer via xpath. And .click(); is used to perform click action on the given locator.

        driver.findElement(By.id("AddNewComment_CommentTitle")).sendKeys("Samsung's new Screen");
        //.findElement(By.id("Locator")) will find the locator by unique id and .sendKeys("data"); will auto input the added data in the locator.

        driver.findElement(By.id("AddNewComment_CommentText")).sendKeys("Awesome display and various resolution options with dynamic display!!");

        driver.findElement(By.xpath("//button[@class=\"button-1 news-item-add-comment-button\"]")).click();

        String Comment = driver.findElement(By.xpath("//div[@id='comments']//div[2]//div[1]")).getText();
        //stored the locator value in a 'String' which is Comment and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'
        System.out.println(Comment);
        //to print the data in the string 'Comment'.

        driver.quit();
        //.quit(); used to close the browser opened by selenium.
    }

}