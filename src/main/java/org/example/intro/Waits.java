package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits extends BaseTest{

    @Test
    public void testExplicitWait() {
        driver.navigate().to("https://demoqa.com/dynamic-properties");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //                        ждем пока станет кликабельной
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("enableAfter"))));

        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("colorChange")),
                "class", "mt-4 text-danger btn btn-primary"));
        driver.findElement(By.id("colorChange")).click();
    }

    @Test
    public void testEtsy(){
        driver.navigate().to("https://www.etsy.com/?ref=lgo");
        WebElement signIn = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']"));
        signIn.click();
        Helper.pause(3000);
    }
}
