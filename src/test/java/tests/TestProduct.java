// filename: tests/Product.java

package tests;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import pageobjects.Product;

public class TestProduct extends Base {

  private Product product;

  @Before
  public void setUp() {
    product = new Product(driver);
  }

  @Test
  public void buyJeans() {
    product.chooseSize();
    assertTrue("Add To Bag not active.", product.addToBagPresent());
    product.addToBag();
    assertTrue("Checkout button is not present.", product.checkoutButtonPresent());
    product.goToCart();
    assertTrue("Cart Proceed to Checkout button is not present.", product.cartProceedToCheckoutPresent());
    product.proceedToCheckout();
  }

}
