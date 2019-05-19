package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class RegistrationPage {

    WebDriver driver;

    By loginField = By.id("passp-field-login");
    By passwordField = By.id("passp-field-passwd");
    By buttonSubmit = new By.ByXPath("//button[@type='submit']");
    public static String mailAddr;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Прохождение пунктов регистрации")
    public void registerUser() throws IOException {

        CSVReader reader = new CSVReader(new FileReader("externalData.csv"), ',', '"', 1);
        List<String[]> allRows = reader.readAll();

        String psswrd = null;
        String login = null;

        int i = 0;

        for (String[] row : allRows) {
            if (i == 0) login = row[0];
            if (i == 1) psswrd = row[0];
            if (i == 2) mailAddr = row[0];

            i++;
        }


        driver.findElement(loginField).sendKeys(login);
        driver.findElement(buttonSubmit).click();
        driver.findElement(passwordField).sendKeys(psswrd);
        driver.findElement(buttonSubmit).click();
    }
}