package org.example.intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper {

    private WebDriver driver;
    private  Alert alert;
    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptAlert(){
        alert.accept();
    }
    public void dismissAlert(){
        alert.dismiss();
    }
    public void sendKeysAlert(String txt){
        alert.sendKeys(txt);

    }
}
