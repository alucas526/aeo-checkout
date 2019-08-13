// filename: pageobjects/Login.java

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {

  private By username = By.cssSelector(".qa-input-username");
  private By usernameField = By.name("username");
  private By password = By.cssSelector(".qa-input-password");
  private By passwordField = By.name("password");
  private By forgotPassword = By.cssSelector(".qa-link-forgot-password");
  private By loginButton = By.cssSelector(".qa-btn-login");
  private By createAccount = By.cssSelector(".qa-btn-create-account");
  private By loggedInName = By.cssSelector(".qa-firstname");

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
