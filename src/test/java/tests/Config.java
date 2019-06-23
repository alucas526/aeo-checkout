// filename: tests/Config.java

package tests;

public class Config {
  public static final String baseUrl = System.getProperty("baseUrl", "https://www.ae.com/us/en");
  public static final String browser = System.getProperty("browser", "chrome");
}
