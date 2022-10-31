package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// all the import classes for web drivers and selenium.

public class Products {

    protected static WebDriver driver;
    // created driver obj for WebDriver to use it for WebDriver to perform functions on webpage.

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        //setProperty is used to locate the Chrome web browser location in order to use Chrome browser later.

        driver = new ChromeDriver();
        // used to open the Chrome browser.

        driver.manage().window().maximize();
        //.maximize(); to keep the window in fullscreen

        driver.get("https://demo.nopcommerce.com/");
        // .get("URL"); to go to that link in the opened browser window.

        driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[@href='/computers']")).click();
        //.findElement(By.xpath("locator")); to locate the locator computer via xpath. And .click(); is used to perform click action on the given locator.

        System.out.println("Categories in Computers are : ");
        //to display the message written in "".

        String Desktop = driver.findElement(By.xpath("//h2//a[@title='Show products in category Desktops']")).getText();
        //stored the locator value in a 'String' which is Desktop and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'
        System.out.println(Desktop);
        //to print the data in the string 'Desktop'

        String Notebooks = driver.findElement(By.xpath("//h2//a[@title='Show products in category Notebooks']")).getText();
        System.out.println(Notebooks);

        String Software = driver.findElement(By.xpath("//h2//a[@title=\"Show products in category Software\"]")).getText();
        System.out.println(Software);

        driver.quit();
        //.quit(); used to close the browser opened by selenium.

    }

}