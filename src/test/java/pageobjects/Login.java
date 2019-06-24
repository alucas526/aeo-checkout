// filename: pageobjects/Login.java

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class Login extends Base {

  private WebDriver driver;
  By username = By.cssSelector(".qa-input-username");
  By usernameField = By.name("username");
  By password = By.cssSelector(".qa-input-password");
  By passwordField = By.name("password");
  By forgotPassword = By.cssSelector(".qa-link-forgot-password");
  By loginButton = By.cssSelector(".qa-btn-login");
  By createAccount = By.cssSelector(".qa-btn-create-account");
  By loggedInName = By.cssSelector(".qa-firstname");

  public Login(WebDriver driver) {
    super(driver);
  }

  public void loginAsExistingUser(String user, String pass) {
    visit("/login");
    isDisplayed(username, 10);
    isDisplayed(password, 10);
    isDisplayed(loginButton, 10);
    click(username);
    type(user, usernameField);
    click(password);
    type(pass, passwordField);
    click(loginButton);
  }

  // Assertion methods

  public Boolean loginSuccessful() {
    isDisplayed(loggedInName, 10);
    return isDisplayed(loggedInName);
  }

}
