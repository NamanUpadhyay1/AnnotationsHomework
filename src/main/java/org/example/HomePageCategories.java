package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// all the import classes for web drivers and selenium.

public class HomePageCategories {

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

        System.out.println("The Menus on home-page are as follows : ");
        // to print the message in the "".

        String Computers = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/computers\"]")).getText();
        //stored the locator value in a 'String' which is Computers and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'
        System.out.println(Computers);
        //to print the data which is in string 'Computers'.

        String Electronics = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/electronics\"]")).getText();
        System.out.println(Electronics);

        String Apparel = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/apparel\"]")).getText();
        System.out.println(Apparel);

        String DigitalDownloads = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/digital-downloads\"]")).getText();
        System.out.println(DigitalDownloads);

        String Books = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/books\"]")).getText();
        System.out.println(Books);

        String Jewelry = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/jewelry\"]")).getText();
        System.out.println(Jewelry);

        String GiftCards = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/gift-cards\"]")).getText();
        System.out.println(GiftCards);

        driver.quit();
        //.quit(); used to close the browser opened by selenium.

    }

}