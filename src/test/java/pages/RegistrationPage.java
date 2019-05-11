package pages;
import com.opencsv.CSVWriter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import java.io.FileWriter;



public class RegistrationPage {


    WebDriver driver;

    By loginField = By.id("passp-field-login");
    By passwordField = By.id("passp-field-passwd");
    By buttonSubmit = new By.ByXPath("//button[@type='submit']");
    public static String var1;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerUser() throws IOException {

//        String csv = "data2.csv";
//        CSVWriter writer = new CSVWriter(new FileWriter(csv));
//        //Create record
//        String [] record = "4,David,Miller,Australia,30".split(",");
//        //Write the record to file
//        writer.writeNext(record);
//        //close the writer
//        writer.close();

        CSVReader reader = new CSVReader(new FileReader("data2.csv"), ',' , '"' , 1);
        List <String[]> allRows = reader.readAll();

        String var2 = null;

        int i=0;

        for(String[] row : allRows) {
           if (i==0) var1 = row[0];
            if (i==1) var2 = row[0];
            i++;
        }

        driver.findElement(loginField).sendKeys(var1);
        driver.findElement(buttonSubmit).click();
        driver.findElement(passwordField).sendKeys(var2);
        driver.findElement(buttonSubmit).click();
    }
}