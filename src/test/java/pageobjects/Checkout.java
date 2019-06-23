// filename: pageobjects/Checkout.java

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import static org.junit.Assert.assertTrue;

public class Checkout extends Base {

  private WebDriver driver;
  By placeOrder = By.cssSelector(".qa-btn-place-order");

  public Checkout(WebDriver driver) {
    super(driver);
  }

  // Assertion methods

  public Boolean placeOrderButtonPresent() {
    isDisplayed(placeOrder, 10);
    return isDisplayed(placeOrder);
  }

}