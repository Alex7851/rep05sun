package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class RegistrationPage {


    WebDriver driver;

    By loginField = By.id("passp-field-login");
    By passwordField = By.id("passp-field-passwd");
    By buttonSubmit = new By.ByXPath("//button[@type='submit']");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerUser() {
        driver.findElement(loginField).sendKeys("alx.test@yandex.ru");
        driver.findElement(buttonSubmit).click();
        driver.findElement(passwordField).sendKeys("Test123");
        driver.findElement(buttonSubmit).click();
    }
}