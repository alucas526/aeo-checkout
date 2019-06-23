// filename: pageobjects/Product.java

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class Product extends Base {

  private WebDriver driver;
  By sizeChartTextLink = By.cssSelector(".psp-sizechart-link.text-left");
  By sizeDropdown = By.cssSelector(".dropdown-text");
  By sizeChoice = By.linkText("29 X 30");
//  By addToBag = By.cssSelector(".btn.btn-primary.qa-btn-add-to-bag.ember-view");
  By addToBag = By.cssSelector(".qa-btn-add-to-bag");
  By checkoutButton = By.cssSelector(".qa-view-bag-btn");
  By proceedToCheckout = By.xpath("(//*[@class='btn btn-primary btn-block btn-go2checkout qa-btn-go2checkout'])[2]");

  public Product(WebDriver driver) {
    super(driver);
    visit("/p/0111_4680_482?menu=cat4840004");
    assertTrue("Size chart is not present; not a product page.", driver.findElement(sizeChartTextLink).isDisplayed());
  }

  public void chooseSize() {
    isDisplayed(sizeChartTextLink);
    isDisplayed(sizeDropdown, 10);
    click(sizeDropdown);
    isDisplayed(sizeChoice, 10);
    click(sizeChoice);
  }

  public void addToBag() {
    isDisplayed(addToBag);
    click(addToBag);
    System.out.println("Added to Bag.");
  }

  public void goToCart() {
    isDisplayed(checkoutButton);
    click(checkoutButton);
    System.out.println("Going to Cart.");
  }

  public void proceedToCheckout() {
    isDisplayed(proceedToCheckout, 10);
    click(proceedToCheckout);
    System.out.println("Proceeding to Checkout.");
  }

  // Assertion methods

  public Boolean addToBagPresent() {
    isDisplayed(addToBag, 10);
    return isDisplayed(addToBag);
  }

  public Boolean checkoutButtonPresent() {
    isDisplayed(checkoutButton, 10);
    return isDisplayed(checkoutButton);
  }

  public Boolean cartProceedToCheckoutPresent() {
    isDisplayed(proceedToCheckout, 10);
    return isDisplayed(proceedToCheckout);
  }

}