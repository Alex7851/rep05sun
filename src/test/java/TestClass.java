import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.InboxPage;
import pages.RegistrationPage;
import pages.SendPage;
import org.openqa.selenium.By;
import pages.YandexPage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class TestClass {

    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    @Parameters({"os", "browser", "url", "node"})
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        SetupTestDriver setupTestDriver = new SetupTestDriver(os, browser, url, node);
        driver = setupTestDriver.getDriver();
    }
//    @BeforeTest

//    public void setup() {
//
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://yandex.ru");
//
//    }

    YandexPage yandexPage;
    RegistrationPage regPage;
    InboxPage inboxPage;
    SendPage sendPage;

    @Test

    public void CheckSomething() throws IOException {

        yandexPage = new YandexPage(driver);
        regPage = new RegistrationPage(driver);
        inboxPage = new InboxPage(driver);
        sendPage = new SendPage(driver);

        yandexPage.clickToMail();
        regPage.registerUser();

        if (inboxPage.checkInboxes()) {

            inboxPage.countMails();
            if (sendPage.checkSendForm()) {
                sendPage.sendMail();

            }

        }


    }
    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }


}
