package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBox {
    WebDriver driver;

    @Test
    public void testCheckBox(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/checkbox");

        WebElement clickButton = driver.findElement(By.xpath("//span[contains(text(),'Check Box')]"));
        clickButton.click();

        WebElement selectButton = driver.findElement(By.xpath("(//button[@title='Toggle'])[1]"));
        selectButton.click();

        WebElement selectButton2 = driver.findElement(By.xpath("(//button[@title='Toggle'])[2]"));
        selectButton2.click();

        WebElement clickButtonCommands = driver.findElement(By.className("//span[@class='rct-checkbox']"));
        clickButtonCommands.click();
    }


}
