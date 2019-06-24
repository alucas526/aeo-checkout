// filename: pageobjects/Login.java

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class Login extends Base {

  private WebDriver driver;
  By username = By.cssSelector(".qa-input-username");
  By password = By.cssSelector(".qa-input-password");
  By forgotPassword = By.cssSelector(".qa-link-forgot-password");
  By loginButton = By.cssSelector(".qa-btn-login");
  By createAccount = By.cssSelector(".qa-btn-create-account");

  public Login(WebDriver driver) {
    super(driver);
//    assertTrue("Sign In button is not present; not the login page.", isDisplayed(loginButton, 10));
  }

  public void loginAsExistingUser(String user, String pass) {
    visit("/login");
    isDisplayed(username, 10);
    isDisplayed(password, 10);
    isDisplayed(loginButton, 10);
    click(username);
    type(user, username);
    click(password);
    type(pass, password);
    click(loginButton);
    System.out.println("Signing In.");
  }

  // Assertion methods

}