import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest extends BaseTest {

  @Test
    public void authorizationIsInvalid() {
    browser.get("https://www.saucedemo.com");
    browser.findElement (By.xpath("//input[@placeholder='Username']")).sendKeys("1234");
    browser.findElement (By.xpath("//input[@placeholder='Password']")).sendKeys("12345");
    browser.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
    String errorMessage = browser.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
    assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
  }

  @Test
  public void authorizationIsValid() {
    browser.get("https://www.saucedemo.com");
    browser.findElement (By.id("user-name")).sendKeys("standard_user");
    browser.findElement (By.name("password")).sendKeys("secret_sauce");
    browser.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
    boolean isPresent = browser.findElement(By.cssSelector(".title")).isDisplayed();
    assertTrue(isPresent, "Register button is not displayed");
  }

  @Test
  public void lockedUser () {
    browser.get("https://www.saucedemo.com");
    browser.findElement (By.cssSelector("#user-name")).sendKeys("locked_out_user");
    browser.findElement (By.cssSelector("#password")).sendKeys("secret_sauce");
    browser.findElement(By.name("login-button")).click();
    String errorMessage = browser.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
    assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.");
  }
}