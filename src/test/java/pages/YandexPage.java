package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.*;


public class YandexPage {

    WebDriver driver;
    By enterField = new By.ByXPath("//a[@class='home-link home-link_black_yes']");

Logger logger =LogManager.getLogger("YandexPage");
    public YandexPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Вход на почту яндекса с главной страницы")

    public void clickToMail() {

        driver.findElement(enterField).click();
        logger.debug("Поле входа в почту");
        logger.info("Поле входа в почту");
    }
}
