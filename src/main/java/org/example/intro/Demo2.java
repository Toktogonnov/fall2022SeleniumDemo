package org.example.intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo2 {

    static Faker faker = new Faker();

    WebDriver driver;

    @Test
    public void testDemo2() {



        WebDriverManager.chromedriver().setup();// Configure ChromeDriver to connect browser
            WebDriver driver = new ChromeDriver(); // creating instance of chromedriver
            driver.manage().window().maximize(); // Maximizing window
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// Driver will wait 20 second
            driver.get("https://demoqa.com/text-box");



            String name = faker.name().fullName();
            String email = faker.internet().emailAddress();
            String currentAddress = faker.address().fullAddress();
            String permanentAddress = faker.address().secondaryAddress();


            WebElement userName = driver.findElement(By.id("userName"));
            userName.sendKeys(name);

            WebElement userEmail = driver.findElement(By.id("userEmail"));
            userEmail.sendKeys(email);

            WebElement currentAddress1 = driver.findElement(By.id("currentAddress"));
            currentAddress1.sendKeys(currentAddress);

            WebElement permanentAddress1 = driver.findElement(By.id("permanentAddress"));
            permanentAddress1.sendKeys(permanentAddress);


//
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,250)", "");


            WebElement  submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

            WebElement actualNameElement = driver.findElement(By.id("name"));
            WebElement actualEmailElement = driver.findElement(By.id("email"));
            WebElement actualCurrentAddressElement = driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
            WebElement actualPermanentAddressElement = driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]"));


            String actualNameText = actualNameElement.getText();
            String actualEmailText = actualEmailElement.getText();
            String actualCurrentAddressText = actualCurrentAddressElement.getText();
            String actualPermanentAddressText= actualPermanentAddressElement.getText();

            Assert.assertTrue(actualNameText.contains(name));
            Assert.assertEquals(actualEmailText,"Name:"+name);
            Assert.assertTrue(actualEmailText.contains(email));
            Assert.assertEquals(actualEmailText,"Name:"+email);
            Assert.assertTrue(actualCurrentAddressText.contains(currentAddress));
            Assert.assertEquals(actualCurrentAddressText,"CurrentAddress"+currentAddress);
            Assert.assertTrue(actualPermanentAddressText.contains(permanentAddress));
            Assert.assertEquals(actualPermanentAddressText,"PermanentAddress"+permanentAddress);


    }
    @AfterClass
    public void setUp(){
            driver.close();

    }
//
//    public static String fakeName() {
//        return faker.name().fullName();
//    }
//
//    public static String fakeEmail() {
//        return faker.internet().emailAddress();
//    }
//
//    public static String fakeAddress() {
//        return faker.address().fullAddress();
//    }
//
//    public static String fakePermanentAddress() {
//        return faker.address().secondaryAddress();
//    }

}
