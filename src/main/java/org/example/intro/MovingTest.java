package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MovingTest extends BaseTest {


    @Test
    public void test() {
        driver.get("https://www.imoving.com/full-inventory/#!/");
        WebElement houseMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseMenu);
        select.selectByVisibleText("My Apartment");
        Helper.pause(3000);

        WebElement moveSizeMenu = driver.findElement(By.id("hp-nav-select-house"));
        Select select2 = new Select(moveSizeMenu);
        select2.selectByVisibleText("Just a few Items");
        Helper.pause(3000);

        WebElement clickQuotes = driver.findElement(By.xpath("//button[@class='btn btn-white quickQuoteLink']"));
        clickQuotes.click();
        Helper.pause(3000);

        WebElement continuesBox = driver.findElement(By.xpath("//span[@class='col-sm-9 col-xs-12']"));
        continuesBox.click();
        Helper.pause(3000);

        driver.findElement(By.xpath("//div[@class='modal-buttons']/a")).click();
        Helper.pause(3000);
        driver.findElement(By.id("closeTutorial")).click();

        Actions action = new Actions(driver);
        WebElement pictureDresser = driver.findElement(By.xpath("//div[@class='14']//figure"));
        action.moveToElement(pictureDresser).build().perform();
        driver.findElement(By.xpath("//div[@class='14']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();


        WebElement plusBoxDresser = driver.findElement(By.xpath("//span[@class='quantityCounterBlock']//button[@class='quantity-plus']"));
        action.doubleClick(plusBoxDresser).perform();


        WebElement bedImageContainer = driver.findElement(By.xpath("//div[@class='13']//figure"));
        action.moveToElement(bedImageContainer).build().perform();
        driver.findElement(By.xpath("//div[@class='13']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        Helper.pause(3000);
        WebElement plusBoxBed = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[3]"));
        action.doubleClick(plusBoxBed).perform();

        WebElement tvImageContainer = driver.findElement(By.xpath("//div[@class='12']//figure"));
        action.moveToElement(tvImageContainer).build().perform();
        driver.findElement(By.cssSelector("div[class='12'] div[class='add-item-mob visible-xs-block visible-sm-block'] a[class='btn btn-blue']")).click();
        Helper.pause(3000);
        WebElement plusBoxTv = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[5]"));
        action.doubleClick(plusBoxTv).perform();

        WebElement clickKitchen = driver.findElement(By.xpath("(//figcaption[@class='hidden-xs hidden-sm'])[4]"));
        clickKitchen.click();
        action.moveToElement(clickKitchen).build().perform();
        action.doubleClick(clickKitchen).perform();
        driver.findElement(By.xpath("//button[@class='quantity-plus']")).click();

        WebElement saveAction = driver.findElement(By.xpath("//div[@class='col-sm-9']"));
        saveAction.click();
        Helper.pause(3000);

        WebElement addBoxSmall = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[1]"));
        addBoxSmall.click();
        Helper.pause(3000);

        WebElement addBoxMedium = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[2]"));
        addBoxMedium.click();
        Helper.pause(3000);

        WebElement addBoxBig = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[3]"));
        addBoxBig.click();
        Helper.pause(3000);

        WebElement addContinue = driver.findElement(By.xpath("(//a[@class='btn btn-blue'])[3]"));
        addContinue.click();
        Helper.pause(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement addAddress = driver.findElement(By.xpath("(//input[@type='text'])[10]"));
        addAddress.sendKeys("72959 638 Avenue, Auburn, NE, 68305");
        Helper.pause(3000);
        driver.findElement(By.xpath("(//button[@class='btn btn-green save-instructions'])[1]")).click();

        WebElement addDropOfAddress = driver.findElement(By.xpath("(//input[@type='text'])[13]"));
        addDropOfAddress.sendKeys("Los Angeles, CA 90001, USA");
        Helper.pause(3000);
        driver.findElement(By.xpath("(//button[@class='btn btn-green save-instructions'])[3]")).click();


//        js.executeScript("window.scrollBy(0,250)", "");
//        WebElement addData = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
//        addData.click();
//        driver.findElement(By.xpath("(//button[@class='btn btn-default btn-sm'])[2]")).click();
//        Helper.pause(3000);


        js.executeScript("window.scrollBy(0,250)", "");
        WebElement confirm = driver.findElement(By.xpath("//button[@class='btn btn-blue confirm']"));
        confirm.click();
        driver.findElement(By.xpath("(//button[@type='submit'])[7]")).click();
        Helper.pause(3000);



//        WebElement addSofa = driver.findElement(By.xpath("(//figcaption[@class='hidden-xs hidden-sm'])[5]"));
//        addSofa.click();
//        action.moveToElement(addSofa).build().perform();
//        action.doubleClick(addSofa).perform();
//        driver.findElement(By.xpath("//button[@class='quantity-plus']")).click();
//
////
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,250)", "");
//        WebElement boxItem = driver.findElement(By.xpath("(//div[@class='arrowOpenRightNavigation leftArrowNavi'])[2]"));
//        boxItem.click();
//        driver.findElement(By.xpath("(//span[@class='roomPanelIcon quantity-plus1'])[3]")).click();
//        Helper.pause(3000);




//        WebElement expectedItems = driver.findElement(By.xpath("//span[@class='room-counter']"));
//        Assert.assertEquals(expectedItems.getText(), "9 items");
//
//        WebElement dresser = driver.findElement(By.xpath("//h3[text()='Dresser']"));
//        Assert.assertEquals(dresser.getText(), "Dresser");

    }
}
