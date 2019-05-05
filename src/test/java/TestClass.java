import io.qameta.allure.Step;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.RegistrationPage;
import pages.SendPage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class TestClass {

    WebDriver driver;

    @BeforeTest

    public void setup() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://yandex.ru");
        By enterField = new By.ByXPath("//a[@class='home-link home-link_black_yes']");
        driver.findElement(enterField).click();
    }

    RegistrationPage regPage;
    InboxPage inboxPage;
    SendPage sendPage;

    @Test

    public void CheckSomething() {


        regPage = new RegistrationPage(driver);
        inboxPage = new InboxPage(driver);
        sendPage = new SendPage(driver);

        regPage.registerUser();

        if (inboxPage.checkInboxes()) {

            inboxPage.countMails();
            if (sendPage.checkSendForm()) {
                sendPage.sendMail();

            }

        }


    }



}
