package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import static pages.RegistrationPage.mailAddr;

public class SendPage {

    WebDriver driver;

    By sendFieldIndicator = By.className("ns-view-compose-fields-box");
    By recepientField = new By.ByXPath("//div[@class='js-compose-field mail-Bubbles']");
    By mainTextField = new By.ByXPath("//div[@id='cke_1_contents']/div");
    By mainTextFieldForIE = new By.ByXPath("//span[@id='cke_1_contents']/div");
    By themeField = new By.ByXPath("//label[@data-key='view=compose-field-subject']");
    By themeFieldForFirefox = new By.ByXPath("//label[@data-key='view=compose-field-subject']/div[@class='mail-Compose-Field-Input']/input");
    By buttonSubmit = new By.ByXPath("//button[@type='submit']");

    public SendPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Отправка письма с данными")

    public void sendMail() {

        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = caps.getBrowserName();
        int countMails = pages.InboxPage.cntMails;
        String strTheme = "Количество писем (данные от тестировщика)";
        String strText = "Количество писем полученных с адреса alex7851@yandex.ru составляет: " + countMails;

        recepientField.findElement(driver).sendKeys(mailAddr);
        themeField.findElement(driver).click();


        themeFieldForFirefox.findElement(driver).sendKeys(strTheme);
        if (browserName.contains("internet")) {
            mainTextFieldForIE.findElement(driver).click();
            mainTextFieldForIE.findElement(driver).sendKeys(strText);
        } else {
            mainTextField.findElement(driver).click();
            mainTextField.findElement(driver).sendKeys(strText);
        }


        driver.findElement(buttonSubmit).click();

    }

    public boolean checkSendForm() {
        return driver.findElements(sendFieldIndicator).size() == 1;
    }
}