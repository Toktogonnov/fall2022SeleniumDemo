package org.example.intro;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UploadDownloadDemo extends BaseTest{

    @Test
    public void test2(){
        driver.navigate().to("https://demoqa.com/upload-download");
        driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\sjimp\\OneDrive\\Изображения\\Снимки экрана");
        Helper.pause(3000);
    }
}
