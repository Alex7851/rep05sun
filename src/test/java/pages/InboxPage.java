package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.RegistrationPage.mailAddr;

public class InboxPage {

    public static int cntMails;
    WebDriver driver;

    By inboxIndicator = By.className("mail-ComposeButton-Text");
    By searchField = By.className("textinput__control");
    By enterIco = new By.ByXPath("//div[@class='mail-SearchContainer has-left-gap']/button");
    By countMails = By.className("ns-view-messages-item-wrap");


    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Определение количества писем с адреса alex7851@yandex.ru")

    public void countMails() {
        driver.findElement(searchField).sendKeys(mailAddr);
        driver.findElement(enterIco).click();
        String url = driver.getCurrentUrl();
        url = url + "&fid=1";

        driver.get(url);
        driver.navigate().refresh();

        cntMails = driver.findElements(countMails).size();
        System.out.println("Количество писем " + cntMails);
        driver.findElement(inboxIndicator).click();
    }

    public boolean checkInboxes() {
        return driver.findElements(inboxIndicator).size() == 1;
    }
}