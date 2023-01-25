package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionDemo {
    WebDriver driver;

    @Test
    public void testRadioButton() throws InterruptedException{

        driver.get("https://demoqa.com/radio-button");
        WebElement yesButton = driver.findElement(By.xpath("//*[@id=\"item-2\"]"));
        yesButton.click();

        WebElement clickButton = driver.findElement(By.xpath(""));

    }

    @Test
    public void testRightClick(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickBtn= driver.findElement(By.xpath("doubleClickBtn"));


        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        Assert.assertEquals(driver.findElement(By.id("doubleClickMassege")).getText(), " you have done right click");
    }

    @Test
    public void test(){
        driver= new ChromeDriver();
        driver.get("https://demoqa.com/buttons");

        WebElement rightClickBtn = driver.findElement(By.xpath("rightClickBtn"));
        Actions actions = new Actions(driver);
        actions.click(rightClickBtn).perform();
        Assert.assertEquals(driver.findElement(By.id("rigthClickMessage")).getText().contains("you have done a right click"),"you have done a right click");
    }

    public static void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
