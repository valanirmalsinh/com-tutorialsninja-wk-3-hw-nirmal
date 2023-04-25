package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    //1.1 create method with name "selectMyAccountOptions" it has one parameter name
    //Create the class MyAccountsTest
    //1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    //1.2 This method should click on the options whatever name is passed as parameter.
    // (Hint: Handle List of Element and Select options)
    public void selectMyAccountOptions(String option) {
        try {
            List<WebElement> list = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu dropdown-menu-right']//li"));
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(option)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu dropdown-menu-right']//li"));
        }

    }

    @Test
    //    1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter
        selectMyAccountOptions("Register");
        //“Register”
        // 1.3 Verify the text “Register Account”.
        verifyText(By.xpath("//h1[contains(text(),'Register Account')]"), "Register Account");
    }

    @Test
    //    2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login"
        selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        verifyText(By.xpath("//h2[contains(text(),'Returning Customer')]"), "Returning Customer");
    }

    @Test
    //    3. Test name verifyThatUserRegisterAccountSuccessfully()
    public void verifyThatUserRegisterAccountSuccessfully() {
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //Enter First Name
        sendTextToElement(By.name("firstname"), "John");
        //Enter Last Name
        sendTextToElement(By.name("lastname"), "Wick");
        //Enter Email
        sendTextToElement(By.name("email"), "jwdanger@gmail.com");
        //Enter Telephone
        sendTextToElement(By.name("telephone"), "123654789");
        //Enter Password
        sendTextToElement(By.id("input-password"), "Password212");
        //Enter Password Confirm
        sendTextToElement(By.id("input-confirm"), "Password212");
        //Select Subscribe Yes radio button
        clickOnElement(By.xpath("(//input[@type='radio'])[2]"));
        //Click on Privacy Policy check box
        clickOnElement(By.name("agree"));
        //Click on Continue button
        clickOnElement(By.xpath("//input[@type='submit']"));
        //Verify the message “Your Account Has Been Created!”
        verifyText(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"), "Your Account Has Been Created!");
        //Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //Click on My Account Link.
        clickOnElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[3]"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        //Verify the text “Account Logout”
        verifyText(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
        //Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @Test
        //Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //Enter Email address
        sendTextToElement(By.id("input-email"), "jwdanger@gmail.com");
        //Enter Password
        sendTextToElement(By.name("password"), "Password212");
        //Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //Verify text “My Account”
        verifyText(By.xpath("//h2[contains(text(),'My Account')]"), "My Account");
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        //Verify the text “Account Logout”
        verifyText(By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");
        //Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}