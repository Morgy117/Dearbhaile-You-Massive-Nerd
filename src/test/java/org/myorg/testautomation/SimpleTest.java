package org.myorg.testautomation;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.graphwalker.java.annotation.GraphWalker;

import java.nio.file.Path;
import java.nio.file.Paths;

@GraphWalker(value = "random(reached_vertex(v_Home))", start = "v_LoginPage")
public class SimpleTest extends ExecutionContext implements Login {
    public final static Path MODEL_PATH = Paths.get("org/myorg/testautomation/Login.graphml");
    static ChromeDriver driver;
    @BeforeExecution
    public void setup() {
        System.setProperty("webdriver.chrome.driver","drivers/chrome/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Override
    public void v_Home() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://the-internet.herokuapp.com/login" );
    }

    @Override
    public void e_Login() {
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
    }

    @Override
    public void v_LoginPage() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://the-internet.herokuapp.com/secure" );
    }}
