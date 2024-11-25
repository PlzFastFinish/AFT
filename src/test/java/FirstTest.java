import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest {

  @Test
    public void zipCode4DigitsCheck() {
      //. Открыть браузер
      //. Зайти на сайт
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-Maximized");
    options.addArguments("headless");
    WebDriver browser = new ChromeDriver();


    browser.get("https://sharelane.com/cgi-bin/register.py");

    browser.findElement (By.name("zip_code")).sendKeys("1234");
    browser.findElement(By.xpath("//input[@value='Continue']")).click();
    String errorMessage = browser.findElement(By.cssSelector("[class=error_message]")).getText();
    assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits");
    browser.close();
  }

  @Test
  public void zipCode5DigitsCheck() {

    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-Maximized");
    options.addArguments("headless");
    WebDriver browser = new ChromeDriver();
    browser.get("https://sharelane.com/cgi-bin/register.py");

    browser.findElement (By.name("zip_code")).sendKeys("12345");
    browser.findElement(By.xpath("//input[@value='Continue']")).click();
    boolean isPresent = browser.findElement(By.xpath("//input[@value='Register']")).isDisplayed();
    assertTrue(isPresent, "Register button is not displayed");
    browser.close();
  }


}