package org.example.intro;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebTables extends BaseTest {


    @Test
    public void testWebTables() {
        Faker faker = new Faker();
        driver.get("https://demoqa.com/webtables");
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();
        WebElement addFirstName = driver.findElement(By.id("firstName"));
        addFirstName.sendKeys(faker.name().firstName());


        WebElement addLastName = driver.findElement(By.id("lastName"));
        addLastName.sendKeys(faker.name().lastName());
        Helper.pause(2000);

        WebElement addEmail = driver.findElement(By.id("userEmail"));
        addEmail.sendKeys(faker.internet().emailAddress());


        WebElement addAge = driver.findElement(By.id("age"));
        addAge.sendKeys("20");


        WebElement addSalary = driver.findElement(By.id("salary"));
        addSalary.sendKeys("4000");


        WebElement addDepartment = driver.findElement(By.id("department"));
        addDepartment.sendKeys("It");


        WebElement clickSubmit = driver.findElement(By.id("submit"));
        clickSubmit.click();
        Helper.pause(2000);


        int n1 = 4;
        int n2 = 7;
        String[][] table = new String[n1][n2];
        int count = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                count++;
                table[i][j] = driver.findElement(By.xpath("(//div[@class='rt-td'])[" + count + "]")).getText();
            }
        }
        System.out.println(Arrays.deepToString(table));

        int count1 = 21;
        for (int i = 0; i < n2; i++) {
            count1++;
            Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='rt-td'])["
                    + count1 + "]")).getText(), table[3][i]);
        }

    }
}
