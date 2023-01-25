package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CssDemo extends BaseTest {
    @Test
    public void cssTest() {
        driver.get("https://www.amazon.com/");

        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);

        WebElement appleText = driver.findElement(By.cssSelector("li[id='p_89/Apple']"));
        System.out.println(appleText.getText());

        WebElement seeMoreButton = driver.findElement(By.xpath("//*[@id=\"brandsRefinements\"]/ul/li[8]/span/div/a/span"));

        seeMoreButton.click();

        List<WebElement> allBrads = driver.findElements(By.xpath("//*[@id=\"brandsRefinements\"]"));


        for (WebElement e : allBrads) {
            System.out.println(e.getText());
            if (e.equals("Google")){
                WebElement googleButton = driver.findElement(By.xpath("//a[contains(text(),'Google')]"));
                googleButton.click();
                  //  driver.findElement(By.xpath("//*[@id=\"p_89/Google\"]/span/a/div/label/i"));
            }
        }
    }
}
