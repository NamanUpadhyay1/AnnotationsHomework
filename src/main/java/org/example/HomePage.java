package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
// All these imports are import classes

public class HomePage {
    protected static WebDriver driver;
    // created driver obj for WebDriver to perform all the driver functions on the webpage.

    @BeforeMethod
    //@BeforeMethod 'block' will run everytime before a method is being executed.
    public void openingBrowser()
    //created an openingBrowser() method inside @BeforeMethod so that the opening of browser which is repeating and will be executed every time any method is being executed.
   {
        System.setProperty("webdriver.chrome.driver","src/test/java/Drivers/chromedriver.exe");
        //setProperty is used to locate the Chrome web browser driver.exe location in order to use Chrome browser later.

        driver = new ChromeDriver();
        //used to open the Chrome browser.

        driver.get("https://demo.nopcommerce.com/");
        // .get("URL"); to go to that link in the opened browser window.

        driver.manage().window().maximize();
        //.maximize(); to keep the window in fullscreen
    }

    @AfterMethod
    //@AfterMethod 'block' will run at the end of every method which is executed.

    public void closingBrowser()
    // created a closingBrowser() method inside @AfterMethod 'block' so that it will be executed at the end of every method/@Test which are running.
    {
        driver.quit();
        //.quit(); used to close the browser.
    }
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        //SimpleDateFormat will give the current date and time while execution in the given pattern.

    public void clickFunction(By by)
    //created a click action method to reuse click action multiple times in different TestCases using this method, here 'By' is key and 'by' is the value.
    {
       driver.findElement(by).click();
       //by is the value of the location and .click(); will perform click action.
    }
    public void inputData(By by,String data)
    //created an input action method to reuse entering data action multiple times in different TestCases using this method, here 'By' is key, 'by' is the value and 'data' is the String Value.
    {
        driver.findElement(by).sendKeys(data);
        //.findElement(By.id("Locator")) will find the locator by unique id and .sendKeys("data"); will auto input the added data in the locator.
    }
    public String printMessage(By by)
    //created an output action method to reuse printing action multiple times in different TestCases using this method, here 'By' is key and 'by' is the value.
    {
        return driver.findElement(by).getText();
        //return will give the data that is store in the 'by' value.
    }

    @Test
    //@Test is one of our testcase.
    public void registrationWithValidCredentials()
            //Test case for registering an account with valid credentials.
    {
       clickFunction(By.className("ico-register"));
        //usage of clickFunction() to perform click action on given locator

        WebElement radioM = (driver.findElement(By.id("gender-male")));
        //WebElement is one of our import class which we used for radiobutton feature on our locator.
        radioM.click();
        //to perform select action on the radio button(locator).

        inputData(By.id("FirstName"),"Naman");
        //usage of inputData(); to enter details in the locator with key and value.

        inputData(By.id("LastName"),"Upadhyay");
        //usage of inputData(); to enter details in the locator with key and value.

        Select DaySelect = new Select(driver.findElement(By.name("DateOfBirthDay")));
        //Select is a selenium import class through which we can use the drop-down select feature with the help from 'By' key of locator.
        DaySelect.selectByValue("21");
        //.selectByValue will select the drop-down item by 'Value'.

        Select MonthSelect = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        //Select is a selenium import class through which we can use the drop-down select feature with the help from 'By' key of locator.
        MonthSelect.selectByValue("9");
        //.selectByValue will select the drop-down item by 'Value'.

        Select YearSelect = new Select(driver.findElement(By.name("DateOfBirthYear")));
        //Select is a selenium import class through which we can use the drop-down select feature with the help from 'By' key of locator.
        YearSelect.selectByValue("2002");
        //.selectByValue will select the drop-down item by 'Value'.

        inputData(By.id("Email"),"namanfusion123"+timeStamp+"@gmail.com");
        //usage of inputData(); to enter details in the locator with key and value.
        //in order to test this a certain feature multiple times such as register, we need to have a unique mail id every time so with a simple concatenation of + timeStamp ~ the object we created for SimpleDateFormat will give unique mail id every time.

        inputData(By.id("Company"),"InfoTech");
        //usage of inputData(); to enter details in the locator with key and value.

        inputData(By.id("Password"),"password123");
        //usage of inputData(); to enter details in the locator with key and value.

        inputData(By.id("ConfirmPassword"),"password123");
        //usage of inputData(); to enter details in the locator with key and value.

        clickFunction(By.id("register-button"));
        //usage of clickFunction() to perform click action on given locator

        System.out.println("Registration homework : (1) ");
        //for the better spacing in console.

        String Msg = printMessage(By.className("result"));
        //Stored value that is returning in printMessage(locator) inside Msg.
        System.out.println(Msg);
        //to print the returning value.
    }

    @Test
    public void emailAFriendForAppleProduct()
            //TestCase for emailing a friend about an apple product.
    {

        clickFunction(By.xpath("//img[@src=\"https://demo.nopcommerce.com/images/thumbs/0000024_apple-macbook-pro-13-inch_415.jpeg\"]"));
        //usage of clickFunction() to perform click action on given locator using xpath.

        clickFunction(By.xpath("//button[@class='button-2 email-a-friend-button']"));
        //usage of clickFunction() to perform click action on given locator using xpath

        inputData(By.id("FriendEmail"),"Chirag@gmail.com");
        //usage of inputData(); to enter details in the locator with key and value.

        inputData(By.id("YourEmailAddress"),"Naman@gmail.com");
        //usage of inputData(); to enter details in the locator with key and value.

        inputData(By.id("PersonalMessage"),"You need to checkout this awesome new apple product!!");
        //usage of inputData(); to enter details in the locator with key and value.

        clickFunction(By.name("send-email"));
        //usage of clickFunction() to perform click action on given locator.

        String Success = printMessage(By.xpath("//div[@class='message-error validation-summary-errors']//li"));
        //stored the locator value in a 'String' which is "Success" and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'

        System.out.println("Email A Friend Homework : (2) ");
        //for the better spacing in console.
        System.out.println(Success);
        //to print the data in the string "Success"
    }
    @Test
    public void menusOnTheHomePageListings()
    {
        System.out.println("Menus Homework : (3) ");
        //for the better spacing in console.

        System.out.println("The Menus on home-page are as follows : ");
        // to print the message in the "".

        String Computers = printMessage(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/computers\"]"));
        //stored the locator value in a 'String' which is Computers and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'.
        System.out.println(Computers);
        //to print the data which is in string 'Computers'.

        String Electronics = printMessage(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/electronics\"]"));
        //stored the locator value in a 'String' which is Electronics and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'.
        System.out.println(Electronics);
        //to print the data which is in string 'Electronics'.

        String Apparel = printMessage(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/apparel\"]"));
        //stored the locator value in a 'String' which is Apparel and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'
        System.out.println(Apparel);
        //to print the data which is in string 'Apparel'.

        String DigitalDownloads = printMessage(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/digital-downloads\"]"));
        //stored the locator value in a 'String' which is DigitalDownloads and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'
        System.out.println(DigitalDownloads);
        //to print the data which is in string 'DigitalDownloads'.

        String Books = printMessage(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/books\"]"));
        //stored the locator value in a 'String' which is Books and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'
        System.out.println(Books);
        //to print the data which is in string 'Books'.

        String Jewelry = printMessage(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/jewelry\"]"));
        //stored the locator value in a 'String' which is Jewelry and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'
        System.out.println(Jewelry);
        //to print the data which is in string 'Jewelry'.

        String GiftCards = printMessage(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/gift-cards\"]"));
        //stored the locator value in a 'String' which is GiftCards and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'
        System.out.println(GiftCards);
        //to print the data which is in string 'GiftCards'.
    }

    @Test
    public void addingANewNewsCommentWithSuccessfulMessage()
    {
        clickFunction(By.xpath("//div[@class='buttons']//a[@href=\"/nopcommerce-new-release\"]"));
        //usage of clickFunction() to perform click action on given locator.

        inputData(By.id("AddNewComment_CommentTitle"),"Samsung's new Screen");
        //usage of inputData(); to enter details in the locator with key and value.

        inputData(By.id("AddNewComment_CommentText"),"Awesome display and various resolution options with dynamic display!!");
        //usage of inputData(); to enter details in the locator with key and value.

        clickFunction(By.xpath("//button[@class=\"button-1 news-item-add-comment-button\"]"));
        //usage of clickFunction() to perform click action on given locator.

        String Comment = printMessage(By.xpath("//div[@id='comments']//div[2]//div[1]"));
        //stored the locator value in a 'String' which is Comment and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'

        System.out.println("NewsComment HomeWork : (4) ");
        //for the better spacing in console.

        System.out.println(Comment);
        //to print the data which is in the string 'Comment'
    }
    @Test
    public void productListItemsUnderTheComputersCategory(){

        clickFunction(By.xpath("//ul[@class = 'top-menu notmobile']//a[@href='/computers']"));
        //usage of clickFunction() to perform click action on given locator.

        System.out.println("Items in Computers Category Homework : (5) ");
        //for the better spacing in console.


        System.out.println("Categories in Computers are : ");
        //to display the message written in "".

        String Desktop = printMessage(By.xpath("//h2//a[@title='Show products in category Desktops']"));
        //stored the locator value in a 'String' which is Desktop and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'.
        System.out.println(Desktop);
        //to print the data in the string 'Desktop'.

        String Notebooks = printMessage(By.xpath("//h2//a[@title='Show products in category Notebooks']"));
        //stored the locator value in a 'String' which is Notebooks and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'.
        System.out.println(Notebooks);
        //to print the data in the string 'Notebooks'.

        String Software = printMessage(By.xpath("//h2//a[@title=\"Show products in category Software\"]"));
        //stored the locator value in a 'String' which is Software and locator found via '.xpath'. And .getText(); is used to store the displayed output into our 'String'.
        System.out.println(Software);
        //to print the data in the string 'Software'.
    }
}