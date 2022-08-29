package net.absoft.homework;

import net.absoft.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class ClickButtons extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Click-Buttons/index.html");
    }

    @Test
    public void testClickOnWebElement() {
        WebElement modal_window = driver.findElement(By.id("myModalClick"));
        driver.findElement(By.id("button1")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(modal_window));
        assertEquals(modal_window.getText(), "Well done for successfully using the click() method!",
                "Message is no correct in alert");
    }

    @Test
    public void testJavaScriptClick() {
        WebElement modal_window = driver.findElement(By.id("myModalJSClick"));
        WebElement click_me_button = driver.findElement(By.id("button2"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", click_me_button);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(modal_window));
        assertEquals(modal_window.getText(), "We can use JavaScript code if all else fails! Remember always try to use the WebDriver Library method(s) " +
                        "first such as WebElement.click(). (The Selenium development team have spent allot of time developing WebDriver functions etc).",
                "Message is no correct in alert");
    }

    @Test
    public void testActionClick() {
        WebElement modal_window = driver.findElement(By.id("myModalMoveClick"));
        WebElement click_me_button = driver.findElement(By.id("button3"));

        new Actions(driver).click(click_me_button).perform();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(modal_window));
        assertEquals(modal_window.getText(), "Advanced user interactions (API) has been developed to enable you to perform more complex interactions such as:",
                "Message is no correct in alert");
    }

}
