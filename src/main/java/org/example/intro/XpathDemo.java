package org.example.intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathDemo {


    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    public void xpath1() {
        WebElement nameText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/label"));
        String expectedEmailText = "Email";
        Assert.assertEquals(nameText.getText(), expectedEmailText);
        WebElement nameText1 = driver.findElement(By.xpath("//label[@id='userEmail-label']"));
        Assert.assertTrue(expectedEmailText.contains(nameText1.getText()));
    }

    @Test
    public void xpathTest() {
        WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("Test123");
        System.out.println("Result is:" + userName.getAttribute("value"));
        Assert.assertEquals(userName.getAttribute("value"), "Test123");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("Karakol312");
        System.out.println("Result is:"+ currentAddress.getAttribute("value"));
        Assert.assertEquals(currentAddress.getAttribute("value"),"Karakol312");

        WebElement submitButton = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        submitButton.click();
    }

    @AfterClass
    public void setClose() {
        driver.close();
        driver.quit();
    }


}
