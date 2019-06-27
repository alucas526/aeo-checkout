// filename: pageobjects/Cart.java

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import static org.junit.Assert.assertTrue;

public class Cart extends Base {

  private By proceedToCheckout = By.xpath("(//*[@class='btn btn-primary btn-block btn-go2checkout qa-btn-go2checkout'])[2]");

  public Cart(WebDriver driver) {
    super(driver);
  }

  public void proceedToCheckout() {
    isDisplayed(proceedToCheckout, 10);
    click(proceedToCheckout);
  }

  // Assertion methods

  public Boolean cartProceedToCheckoutPresent() {
    isDisplayed(proceedToCheckout, 10);
    return isDisplayed(proceedToCheckout);
  }

}
