package org.myorg.testautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.graphwalker.core.machine.ExecutionContext;
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
public class LoginLogoutTest extends ExecutionContext implements Login_2{
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

    @Override
    public void v_Home() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://the-internet.herokuapp.com/secure" );
    }

    @Override
    public void e_Logout() {
        Helpers.waitAndClick(By.xpath("//*[@id=\"content\"]/div/a/i"), waiter);
    }

    @Override
    public void e_Login() {
        Helpers.sendKeysTo(By.id("username"), "tomsmith", driver);
        Helpers.sendKeysTo(By.id("password"), "SuperSecretPassword!", driver);

        Helpers.waitAndClick(By.xpath("//*[@id=\"login\"]/button"), waiter);
    }

    @Override
    public void v_LoginPage() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://the-internet.herokuapp.com/login" );
    }
}
