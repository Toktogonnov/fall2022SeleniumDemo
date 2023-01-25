package org.example.intro;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.naming.directory.NoSuchAttributeException;
import java.time.Duration;
import java.util.List;

public class SeleniumExceptions extends BaseTest {

    @Test
    public void demo1() {
        //NoSuchElementException

        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.id("userName1")).sendKeys("Hello World");
    }

    @Test
    public void noSuchWindowException() {
        //noSuchWindowException

        browserHelper.openURL("https://demoqa.com/text-box");
        browserHelper.switchToWindow(3);
        driver.switchTo().window("hello");
    }

    @Test
    public void noSuchFrameException() {
        browserHelper.openURL("https://demoqa.com/text-box");

    }

    @Test
    public void invalidSelectorExceptionTest() {
        // org.openQa.selenium.InvalidSelectorException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.xpath("//button[@type='button'][100]"));
    }

    @Test
    public void noSuchSessionExceptionTest() {
        //noSuchSessionException
        driver.quit();
        browserHelper.openURL("https://demoqa.com/text-box");
    }

    @Test
    public void stateElementReferenceExceptionTest(){
        browserHelper.openURL("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands) {
            count++;
            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();
            }
        }
    }

    @Test
    public void timeOutExceptionTest(){
        browserHelper.openURL("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();
    }


    @Test
    public void webDriverExceptionTest() {
        //WevDriverException
         browserHelper.openURL("https://www.amazon/test.page");
    }
    @Test
    public void test1(){

        browserHelper.openURL("https://demoqa.com/text-box");
        WebElement link = driver.findElement(By.id("userName1"));
        if(link.getAttribute("href") != null){
            String linkUrl = link.getAttribute("href");
            // do something with linkUrl
        } else {
            System.out.println("The link does not have an href attribute.");
        }
    }

}
