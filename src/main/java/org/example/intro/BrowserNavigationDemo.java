package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserNavigationDemo extends BaseTest{
    @Test
    public void test1(){
        driver.navigate().to("https://www.imoving.com/");
        WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectMenu);
        select.selectByValue("1080");
        WebElement moveSizeMenu = driver.findElement(By.id("hp-nav-select-house"));
        Select select2 = new Select(moveSizeMenu);
        select2.selectByVisibleText("Just a few Items");
        WebElement clickQuotes = driver.findElement(By.xpath("//button[@class='btn btn-white quickQuoteLink']"));
        clickQuotes.click();
        Helper.pause(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.imoving.com/full-inventory/#!/");
        driver.navigate().back();
        Helper.pause(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.imoving.com/");
        driver.navigate().refresh();
        Helper.pause(3000);
        driver.navigate().forward();
        Helper.pause(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.imoving.com/full-inventory/#!/");

    }
}
