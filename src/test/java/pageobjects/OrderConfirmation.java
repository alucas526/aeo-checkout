// filename: pageobjects/OrderConfirmation.java

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmation extends Base {

  private By campaignClose = By.cssSelector(".ac-offer-close");
  private By confirmationMessage = By.cssSelector(".qa-confirmation-message");

  public OrderConfirmation(WebDriver driver) {
    super(driver);
  }

  public void viewConfirmation() {
    isDisplayed(campaignClose, 20);
    click(campaignClose);
  }

  // Assertion methods

  public Boolean confirmationMessageDisplayed() {
    isDisplayed(confirmationMessage, 10);
    return isDisplayed(confirmationMessage);
  }

}
