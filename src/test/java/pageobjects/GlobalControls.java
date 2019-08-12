// filename: pageobjects/GlobalControls.java

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GlobalControls extends Base {

  private By aeLogoLink = By.cssSelector(".logo-link.qa-aeo-logo");
  private By aerieLogoLink = By.cssSelector(".logo-link.qa-aerie-logo");
  private By globalSearch = By.cssSelector(".qa-utilities-search");
  private By globalAccount = By.cssSelector(".qa-utilities-account");
  private By globalFavorites = By.cssSelector(".qa-utilities-favorites");
  private By globalCart = By.cssSelector(".qa-utilities-cart");

  public GlobalControls(WebDriver driver) {
    super(driver);
  }

  public void loginViaGlobalAccount(){
    isDisplayed(globalAccount, 10);
    click(globalAccount);
  }

  // Assertion methods

  public Boolean globalLinksDisplayed(){
    System.out.println("Checking global nav links...");
    isDisplayed(aeLogoLink, 10);
    isDisplayed(aerieLogoLink, 10);
    isDisplayed(globalSearch, 10);
    isDisplayed(globalAccount, 10);
    isDisplayed(globalFavorites, 10);
    isDisplayed(globalCart, 10);
    return true;
  }

}
