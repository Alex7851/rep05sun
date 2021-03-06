package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexPage {

    WebDriver driver;
    By enterField = new By.ByXPath("//a[@class='home-link home-link_black_yes']");

    public YandexPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Вход на почту яндекса с главной страницы")

    public void clickToMail() {

        driver.findElement(enterField).click();

    }
}
