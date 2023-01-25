package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestGlovo extends BaseTest {

    @Test
    public void testDemo() {
        browserHelper.openURL("https://glovoapp.com/");
        WebElement clickButton = driver.findElement(By.xpath("(//span[@class='helio-button__content'])[2]"));
        clickButton.click();

        WebElement inputName = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        inputName.sendKeys("Einar");
        Helper.pause(2000);

        WebElement inputEmail = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
        inputEmail.sendKeys("toktogonoveinar@gmail.com");
        Helper.pause(2000);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
        inputPassword.sendKeys("Eynar.2003");
        Helper.pause(2000);

        WebElement clickButtonSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
        clickButtonSubmit.click();
    }
}



