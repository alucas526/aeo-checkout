// filename: pageobjects/Product.java

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Product extends Base {

  private By sizeChartTextLink = By.cssSelector(".psp-sizechart-link.text-left");
  private By sizeDropdown = By.cssSelector(".dropdown-text");
  private By sizeChoice = By.linkText("29 X 30");
  private By addToBag = By.cssSelector(".qa-btn-add-to-bag");
  private By checkoutButton = By.cssSelector(".qa-view-bag-btn");

  public Product(WebDriver driver) {
    super(driver);
  }

  public void chooseSize() {
    visit("/p/0111_4680_482?menu=cat4840004");
    isDisplayed(sizeChartTextLink);
    isDisplayed(sizeDropdown, 10);
    click(sizeDropdown);
    isDisplayed(sizeChoice, 10);
    click(sizeChoice);
  }

  public void addToBag() {
    isDisplayed(addToBag);
    click(addToBag);
  }

  public void goToCart() {
    isDisplayed(checkoutButton);
    click(checkoutButton);
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

}
