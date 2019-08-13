// filename: steps/UserLogin.java

package steps;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import pageobjects.GlobalControls;
import tests.Base;

import static org.junit.Assert.*;

public class UserLogin extends Base {

  private GlobalControls globalControls;

  public void setUp(){
    globalControls = new GlobalControls(driver);
  }

  @Given("^Customer is at AEO homepage and global controls are visible$")
  public void customerIsAtAEOHomepageAndGlobalControlsAreVisible() {
//    assertTrue("Global elements are not visible.", GlobalControls.globalLinksDisplayed());
    System.out.println("");

  }

  @And("^Customer clicks global account link$")
  public void customerClicksGlobalAccountLink() {
  }

  @Then("^Customer sees Account flyout from the right side of the browser$")
  public void customerSeesAccountFlyoutFromTheRightSideOfTheBrowser() {
  }
}
