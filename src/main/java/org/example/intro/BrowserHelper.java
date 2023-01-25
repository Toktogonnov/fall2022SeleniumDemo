package org.example.intro;

import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {

    private WebDriver driver;

    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void  openURL (String URl){
        driver.navigate().to(URl);
    }

    public void goBack(){
        driver.navigate().back();
    }

    public void goForward(){
        driver.navigate().forward();
    }
    public void refreshThePage(){
        driver.navigate().refresh();
    }

    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }

    public void switchToWindow(int index){
        LinkedList<String> windowsId = new LinkedList<String>(getWindowHandles());
        if (index < 0 || index > windowsId.size()){
            throw new IllegalArgumentException("Invalid index" + index);
        }
        driver.switchTo().window(windowsId.get(index));
    }

}
