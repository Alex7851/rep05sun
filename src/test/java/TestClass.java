import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.InboxPage;
import pages.RegistrationPage;
import pages.SendPage;
import pages.YandexPage;
import java.io.IOException;
import java.net.MalformedURLException;

public class TestClass {

    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    @Parameters({"os", "browser", "url", "node"})
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        SetupTestDriver setupTestDriver = new SetupTestDriver(os, browser, url, node);
        driver = setupTestDriver.getDriver();
    }


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
        inboxPage.countMails();
        sendPage.sendMail();

    }
    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}
