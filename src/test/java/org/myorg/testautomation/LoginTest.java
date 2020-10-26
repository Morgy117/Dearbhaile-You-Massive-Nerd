package org.myorg.testautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@GraphWalker(
        value = "random(edge_coverage(100))",
        start = "v_LoginPage"
)
public class LoginTest extends ExecutionContext implements Login {
    WebDriver driver;
    WebDriverWait waiter;

    @BeforeExecution
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Assert.assertNotNull(driver);
        waiter = new WebDriverWait(driver, 10);
        driver.get("https://the-internet.herokuapp.com/login");
    }

//    @AfterExecution
//    public void cleanup() {
//        if (this.driver != null) {
//            this.driver.quit();
//        }
//    }

    @Override
    public void v_LoginPage() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://the-internet.herokuapp.com/login" );
    }

    @Override
    public void e_Login() {
        //driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
    }

    @Override
    public void v_Home() {
        //String URL = driver.getCurrentUrl();
       // Assert.assertEquals(URL, "https://the-internet.herokuapp.com/secure" );
    }
}
