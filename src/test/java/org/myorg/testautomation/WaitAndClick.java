package org.myorg.testautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitAndClick {
    public static void waitAndClick(By object, WebDriverWait waiter){
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")));
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input"))).click();
    }
}
