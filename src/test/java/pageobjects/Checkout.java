// filename: pageobjects/Checkout.java

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import static org.junit.Assert.assertTrue;

public class Checkout extends Base {

  private WebDriver driver;
  // Address Fields
  By firstName = By.cssSelector(".qa-input-firstname");
  By lastName = By.cssSelector(".qa-input-lastname");
  By address1 = By.cssSelector(".qa-input-streetAddress");
  By address2 = By.cssSelector(".qa-input-streetAddress2");
  By city = By.cssSelector(".qa-input-city");
  By state = By.cssSelector(".qa-select-states");
  By zipCode = By.cssSelector(".qa-input-postalCode");

  // Shipping Options
  By standard = By.name("");
  By twoDay = By.name("");
  By overnight = By.name("");

  // Payment Options
  By creditCard = By.cssSelector(".qa-selectable-option-payment-method-credit-card");
  By creditCardNumber = By.cssSelector(".qa-input-cardNumber");
  By expirationDate = By.cssSelector(".qa-input-expirationDate");
  By securityCode = By.cssSelector(".qa-input-securityCode");
  By phoneNumber = By.cssSelector(".qa-input-phoneNumber");
  By payPal = By.cssSelector(".qa-selectable-option-payment-method-paypal");

  // Final Info
  By emailAddress = By.cssSelector(".qa-input-email"); // anonymous users
  By placeOrder = By.cssSelector(".qa-btn-place-order");
  By placeOrderPayPal = By.cssSelector(".qa-btn-place-order-paypal");

  public Checkout(WebDriver driver) {
    super(driver);
  }

  // Assertion methods

  public Boolean placeOrderButtonPresent() {
    isDisplayed(placeOrder, 10);
    return isDisplayed(placeOrder);
  }

}