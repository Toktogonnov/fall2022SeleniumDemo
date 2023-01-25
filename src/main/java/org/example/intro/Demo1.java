package org.example.intro;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo1 {

    @Test
    public void testDemo1(){

        WebDriverManager.chromedriver().setup();// Configure ChromeDriver to connect browser
        WebDriver driver = new ChromeDriver(); // creating instance of chromedriver
        driver.manage().window().maximize(); // Maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// Driver will wait 20 second

        driver.get("https://demoqa.com/text-box");
        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        fullNameInputField.sendKeys("Einar");
        WebElement emailInputField = driver.findElement(By.id("userEmail"));
        emailInputField.sendKeys("toktogonoveinar@gmail.com");
        WebElement currentAddressInputField = driver.findElement(By.id("currentAddress"));
        currentAddressInputField.sendKeys("Karakol city");
        WebElement permanentAddressInputField = driver.findElement(By.id("permanentAddress"));
        permanentAddressInputField.sendKeys("Living in Bishkek");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();



    }
}
