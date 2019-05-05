package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendPage {

    WebDriver driver;

    By sendFieldIndicator = By.className("ns-view-compose-fields-box");
    By recepientField  = new By.ByXPath("//div[@class='js-compose-field mail-Bubbles']");
    By mainTextField  = new By.ByXPath("//div[@id='cke_1_contents']/div");
    By themeField  = new By.ByXPath("//label[@data-key='view=compose-field-subject']");
    By buttonSubmit = new By.ByXPath("//button[@type='submit']");

    public SendPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendMail() {

        int countMails=  pages.InboxPage.cntMails;
        String strTheme="Количество писем (данные от тестировщика)";
        String strText="Количество писем полученных с адреса alex7851@yandex.ru составляет: " + countMails;

        recepientField.findElement(driver).sendKeys("alex7851@yandex.ru");
        themeField.findElement(driver).click();
        themeField.findElement(driver).sendKeys(strTheme);
        mainTextField.findElement(driver).sendKeys(strText);
        driver.findElement(buttonSubmit).click();

    }
    public boolean checkSendForm(){
        return     driver.findElements(sendFieldIndicator).size()==1;
    }
}