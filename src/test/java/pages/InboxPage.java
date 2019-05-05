package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxPage {

    public static int cntMails;
    WebDriver driver;

    By inboxIndicator = By.className("mail-ComposeButton-Text");
    By searchField = By.className("textinput__control");
    By enterIco  = new By.ByXPath("//div[@class='mail-SearchContainer has-left-gap']/button");
    By countMails = By.className("ns-view-messages-item-wrap");


    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void countMails() {
        driver.findElement(searchField).sendKeys("alex7851@yandex.ru");
        driver.findElement(enterIco).click();
        driver.navigate().refresh();
        cntMails= driver.findElements(countMails).size();
        System.out.println("Количество писем " + cntMails);
        driver.findElement(inboxIndicator).click();
    }
    public boolean checkInboxes(){
        return     driver.findElements(inboxIndicator).size()==1;
    }
}