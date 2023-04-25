package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    //method for click on
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //Method to send text to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //Method to get text from elemrnt
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }



    //Method for mouse hover
    public void mouseHoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();


    }

    //Method for mouse click on element
    public void mouseClickOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    //method to verify text
    public void verifyText(By by, String expectedText) {
        String actualText = driver.findElement(by).getText();
        Assert.assertEquals("Verify the text", expectedText, actualText);

    }
    //select class method
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByVisibleText(text);
    }
    //select by value
    public void selectByValueTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByValue(text);
    }
    //To change quantity
    public void changeQuantity(By id, String text){
        driver.findElement(id).clear();
        driver.findElement(id).sendKeys(text);
    }
}