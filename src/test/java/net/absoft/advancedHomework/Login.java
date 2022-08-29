package net.absoft.homework;

import net.absoft.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Login extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Login-Portal/index.html?");
    }

    @Test
    public void loginWithEmptyPassword() {
        driver.findElement(By.id("text")).sendKeys("inessa");
        driver.findElement(By.id("login-button")).click();
        assertEquals(driver.switchTo().alert().getText(), "validation failed",
                "Message is not correct in alert");
    }

}
