package org.example.intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alert1 extends BaseTest {

    @Test
    public void alertTest() {
        driver.get("https://demoqa.com/alerts");

        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Helper.pause(4000);

    }

    @Test
    public void testExplicitWait() {
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("timerAlertButton"));
        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void testAlertButton(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("confirmButton"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Helper.pause(4000);

        WebElement canselText = driver.findElement(By.id("confirmResult"));
        Assert.assertEquals(canselText.getText(),"You selected Cancel");
    }

    @Test
    public void testAlertButton1(){
        driver.get("https://demoqa.com/alerts");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement alertButton = driver.findElement(By.id("promtButton"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Einar");
        alert.accept();
        Helper.pause(4000);
        WebElement promtResult = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(promtResult.getText(),"You entered Einar");
    }
}
