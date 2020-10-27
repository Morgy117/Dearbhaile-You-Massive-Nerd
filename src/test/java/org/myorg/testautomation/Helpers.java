package org.myorg.testautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {
    public static void waitAndClick(By element,  WebDriverWait waiter){
        waiter.until(ExpectedConditions.presenceOfElementLocated(element));
        waiter.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    
    public static void sendKeysTo(By element, String keys, WebDriver driver){
        WebElement input = driver.findElement(element);
        input.sendKeys(keys);
    }
}
