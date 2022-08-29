package net.absoft.homework;

import net.absoft.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class Checkbox extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    }

    @Test
    public void testDropdownMenus() {
        Select menu1 = new Select(driver.findElement(By.id("dropdowm-menu-1")));
        menu1.selectByVisibleText("JAVA");
        assertEquals(menu1.getFirstSelectedOption().getText(), "JAVA");

        Select menu2 = new Select(driver.findElement(By.id("dropdowm-menu-2")));
        menu2.selectByVisibleText("TestNG");
        assertEquals(menu2.getFirstSelectedOption().getText(), "TestNG");

        Select menu3 = new Select(driver.findElement(By.id("dropdowm-menu-3")));
        menu3.selectByVisibleText("HTML");
        assertEquals(menu3.getFirstSelectedOption().getText(), "HTML");
    }

    @Test
    public void testCheckbox() {
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@value='option-1']"));
        checkbox1.click();
        assertTrue("Checkbox1 should be selected", checkbox1.isSelected());

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@value='option-2']"));
        assertFalse("Checkbox2 should not be selected", checkbox2.isSelected());

        WebElement checkbox3 = driver.findElement(By.xpath("//input[@value='option-3']"));
        checkbox3.click();
        assertFalse("Checkbox3 should be selected", checkbox3.isSelected());

        WebElement checkbox4 = driver.findElement(By.xpath("//input[@value='option-4']"));
        checkbox4.click();
        assertTrue("Checkbox4 should not be selected", checkbox4.isSelected());
    }

    @Test
    public void testRadioButtons() {
        WebElement orange_radio_button = driver.findElement(By.xpath("//input[@value='orange']"));
        orange_radio_button.click();
        assertTrue("Orange should not be selected", orange_radio_button.isSelected());
    }

    @Test
    public void testSelectedAndDisabled() {
        assertTrue("Pumpkin should be selected", driver.findElement(By.xpath("//input[@value='pumpkin']")).isSelected());
        assertFalse("Cabbage should not be enabled", driver.findElement(By.xpath("//input[@value='cabbage']")).isEnabled());

        Select fruits = new Select(driver.findElement(By.id("fruit-selects")));
        assertEquals(fruits.getFirstSelectedOption().getText(), "Grape");
        assertFalse("Orange should not be enabled", driver.findElement(By.xpath("//option[@value='orange']")).isEnabled());
    }
}
