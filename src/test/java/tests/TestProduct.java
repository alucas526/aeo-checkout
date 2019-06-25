// filename: tests/Product.java

package tests;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import pageobjects.Login;
import pageobjects.Product;
import pageobjects.Cart;
import pageobjects.Checkout;

public class TestProduct extends Base {

  private Login login;
  private Product product;
  private Cart cart;
  private Checkout checkout;

  String user = "alucas+testaeo@gmail.com";
  String pass = "P@ss1234!";

  @Before
  public void setUp() {
    login = new Login(driver);
    product = new Product(driver);
    cart = new Cart(driver);
    checkout = new Checkout(driver);

  }

  @Test
  public void buyJeans() {
    product.chooseSize();
    assertTrue("Add To Bag not active.", product.addToBagPresent());
    product.addToBag();
    assertTrue("Checkout button is not present.", product.checkoutButtonPresent());
    product.goToCart();
    assertTrue("Cart Proceed to Checkout button is not present.", cart.cartProceedToCheckoutPresent());
    cart.proceedToCheckout();
    assertTrue("Place Order button is not present.", checkout.placeOrderButtonPresent());
    checkout.anonShipInfo("Pennsylvania");
//    checkout.shippingOption();
//    assertTrue("Expected shipping method not selected.", checkout.shipmentTypeSelected());
    checkout.selectPaymentMethod("PP");
    assertTrue("Expected payment method is not selected", checkout.paymentMethodSelected("PP"));
  }

  @Test
  public void loginSuccess() {
    login.loginAsExistingUser(user, pass);
    assertTrue("Username is not present. Login unsuccessful.", login.loginSuccessful());
  }

}
