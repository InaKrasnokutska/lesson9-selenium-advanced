package net.absoft.homework;

import net.absoft.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ToDoList extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
    }

    @Test
    public void testAddNewToDo() {
        WebElement input_field = driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));
        input_field.click();
        input_field.sendKeys("Task 1");
        input_field.sendKeys(Keys.ENTER);
        input_field.sendKeys("Task 2");
        input_field.sendKeys(Keys.ENTER);
        input_field.sendKeys("Task 3");
        input_field.sendKeys(Keys.ENTER);
        assertEquals(driver.findElement(By.xpath("//ul/li[last()]")).getText(), "Task 3");
    }

    @Test
    public void testDeleteToDo() {
        testAddNewToDo();
        WebElement delete = driver.findElement(By.xpath("//ul/li[last()]/span/i"));
        delete.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(driver.findElements(By.xpath("//li[contains(text(), 'Task 3')]")).isEmpty(), "Task 3 is still in To Do");
        assertEquals(driver.findElement(By.xpath("//ul/li[last()]")).getText(), "Task 2");

    }
}
