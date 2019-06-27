// filename: tests/Product.java

package tests;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import pageobjects.*;

public class TestProduct extends Base {

  private Login login;
  private Product product;
  private Cart cart;
  private Checkout checkout;
  private OrderConfirmation orderConfirmation;

  private String user = "alucas+testaeo@gmail.com";
  private String pass = "P@ss1234!";
  private String[] paymentInfoVisa = {"4111111111111111", "08/22", "444"};
  private String[] paymentInfoMC = {"5555555555554444", "09/23", "666"};

  @Before
  public void setUp() {
    login = new Login(driver);
    product = new Product(driver);
    cart = new Cart(driver);
    checkout = new Checkout(driver);
    orderConfirmation = new OrderConfirmation(driver);
  }

  @Test
  public void buyJeansAnonymousPayPal() {
    product.chooseSize();
    assertTrue("Add To Bag not active.", product.addToBagPresent());
    product.addToBag();
    assertTrue("Checkout button is not present.", product.checkoutButtonPresent());
    product.goToCart();
    assertTrue("Cart Proceed to Checkout button is not present.", cart.cartProceedToCheckoutPresent());
    cart.proceedToCheckout();
    assertTrue("Place Order button is not present.", checkout.placeOrderButtonPresent());
    checkout.anonShipInfo("Pennsylvania");
    checkout.shippingOption("standard");
    assertTrue("Expected shipping method not selected.", checkout.shipmentTypeSelected());
    checkout.selectPaymentMethod("PayPal");
    assertTrue("Expected payment method is not selected", checkout.paymentMethodSelected("PayPal"));
  }

  @Test
  public void buyJeansAnonymousVisa() {
    product.chooseSize();
    assertTrue("Add To Bag not active.", product.addToBagPresent());
    product.addToBag();
    assertTrue("Checkout button is not present.", product.checkoutButtonPresent());
    product.goToCart();
    assertTrue("Cart Proceed to Checkout button is not present.", cart.cartProceedToCheckoutPresent());
    cart.proceedToCheckout();
    assertTrue("Place Order button is not present.", checkout.placeOrderButtonPresent());
    checkout.anonShipInfo("Pennsylvania");
    checkout.shippingOption("standard");
    assertTrue("Expected shipping method not selected.", checkout.shipmentTypeSelected());
    checkout.selectPaymentMethod("Credit Card");
    assertTrue("Expected payment method is not selected", checkout.paymentMethodSelected("Credit Card"));
    checkout.enterPaymentInfo(paymentInfoVisa[0], paymentInfoVisa[1], paymentInfoVisa[2]);
//    orderConfirmation.viewConfirmation();
    assertTrue("Order confirmation message is not displayed.", orderConfirmation.confirmationMessageDisplayed());
  }

  @Test
  public void buyJeansAnonymousMC() {
    product.chooseSize();
    assertTrue("Add To Bag not active.", product.addToBagPresent());
    product.addToBag();
    assertTrue("Checkout button is not present.", product.checkoutButtonPresent());
    product.goToCart();
    assertTrue("Cart Proceed to Checkout button is not present.", cart.cartProceedToCheckoutPresent());
    cart.proceedToCheckout();
    assertTrue("Place Order button is not present.", checkout.placeOrderButtonPresent());
    checkout.anonShipInfo("Pennsylvania");
    checkout.shippingOption("standard");
    assertTrue("Expected shipping method not selected.", checkout.shipmentTypeSelected());
    checkout.selectPaymentMethod("Credit Card");
    assertTrue("Expected payment method is not selected", checkout.paymentMethodSelected("Credit Card"));
    checkout.enterPaymentInfo(paymentInfoMC[0], paymentInfoMC[1], paymentInfoMC[2]);
    assertTrue("Order confirmation message is not displayed.", orderConfirmation.confirmationMessageDisplayed());
  }

  @Test
  public void buyJeansRegisteredMC() {
    login.loginAsExistingUser(user, pass);
    assertTrue("Username is not present. Login unsuccessful.", login.loginSuccessful());
    product.chooseSize();
    assertTrue("Add To Bag not active.", product.addToBagPresent());
    product.addToBag();
    assertTrue("Checkout button is not present.", product.checkoutButtonPresent());
    product.goToCart();
    assertTrue("Cart Proceed to Checkout button is not present.", cart.cartProceedToCheckoutPresent());
    cart.proceedToCheckout();
    assertTrue("Place Order button is not present.", checkout.placeOrderButtonPresent());
    checkout.shippingOption("standard");
    assertTrue("Expected shipping method not selected.", checkout.shipmentTypeSelected());
    checkout.selectPaymentMethod("Credit Card");
    assertTrue("Expected payment method is not selected", checkout.paymentMethodSelected("Credit Card"));
    checkout.enterPaymentInfo(paymentInfoMC[0], paymentInfoMC[1], paymentInfoMC[2]);
//    assertTrue("Order confirmation message is not displayed.", orderConfirmation.confirmationMessageDisplayed());
  }

}
