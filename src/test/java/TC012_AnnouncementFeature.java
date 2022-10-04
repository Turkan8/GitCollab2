import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utulities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TC012_AnnouncementFeature {



    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        // go to https://login1.nextbasecrm.com/ page
        driver.get("https://login1.nextbasecrm.com/");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void create_announcement(){


        //        2. The user should go to the homepage after login in successfully.
        //Enter a valid username

        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("hr43@cybertekschool.com");

        //Enter a valid password

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        //click login button

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();

        //click more button
        WebElement moreButton = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
        moreButton.click();

        //click the Announcement Button
        WebElement announcementButton = driver.findElement(By.xpath("//*[text()='Announcement']"));
        announcementButton.click();

        //switch to iframe
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[1]")));

        // write an announcement
        WebElement announcementBox=driver.findElement(By.xpath("//body[@contenteditable='true']"));
        announcementBox.sendKeys("hello b27 for second times");

        //switch to main html page
        driver.switchTo().defaultContent();

        //click send button
        WebElement sendButton= driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

    }

    @Test
    public void create_announcement_withoutContent(){

//        2. The user should go to the homepage after login in successfully.
        //Enter a valid username

        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("hr43@cybertekschool.com");

        //Enter a valid password

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        //click login button
        WebElement login = driver.findElement(By.xpath("//input[@class='login-btn']"));
        login.click();

        //click more button
        WebElement moreButton = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-more']"));
        moreButton.click();

        //click to announcement button
        WebElement announcementButton= driver.findElement(By.xpath("//span[text()='Announcement']"));
        announcementButton.click();

        //click the send button without content
        WebElement sendButton = driver.findElement((By.xpath("//button[@id='blog-submit-button-save']")));
        sendButton.click();

        //verify error message
        String expectedMessage="The message title is not specified";

        WebElement errorMessage= driver.findElement(By.xpath("//span[text()='The message title is not specified']"));

        String actualMessage= errorMessage.getText();
        System.out.println(actualMessage);

        if(expectedMessage.equals(actualMessage)){
            System.out.println("Test Passed!!!");
        }else {
            System.err.println("Test Failed!!!!!!!!!!");
        }

    }







}
