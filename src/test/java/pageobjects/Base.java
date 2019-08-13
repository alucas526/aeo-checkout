// filename: pageobjects/Base.java

package pageobjects;

import static tests.Config.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Base {

  private WebDriver driver;

  Base(WebDriver driver) {
    this.driver = driver;
  }

  void visit(String url) {
    if (url.contains("http")) {
      driver.get(url);
    } else {
      driver.get(baseUrl + url);
    }
  }

  WebElement find(By locator) {
    return driver.findElement(locator);
  }

  void click(By locator) {
    find(locator).click();
  }

  void type(String inputText, By locator) {
    find(locator).clear();
    find(locator).sendKeys(inputText);
  }

  Boolean isDisplayed(By locator) {
    try {
      return find(locator).isDisplayed();
    } catch (org.openqa.selenium.NoSuchElementException exception) {
      return false;
    }
  }

  Boolean isDisplayed(By locator, Integer timeout) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, timeout);
      wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    } catch (org.openqa.selenium.TimeoutException exception) {
      return false;
    }
    return true;
  }

}
