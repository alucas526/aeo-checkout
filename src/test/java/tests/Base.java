// filename: tests/Base.java

package tests;

import static tests.Config.*;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

  protected WebDriver driver;

  @Rule
  public ExternalResource resource = new ExternalResource() {

    @Override
    protected void before() throws Throwable {
      if (browser.equals("chrome")) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/vendor/chromedriver.exe");
        driver = new ChromeDriver();
      } else if (browser.equals("firefox")) {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/vendor/geckodriver.exe");
        driver = new FirefoxDriver();
      }
      driver.manage().window().maximize();
    }

    @Override
    protected void after() {
      driver.quit();
    }
  };

}
