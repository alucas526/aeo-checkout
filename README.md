# AEO Checkout Automation

This is a small test framework for running through the checkout process on the AEO website. The code is separated in pageobjects and tests, to make everything more easily maintainable. 

I built very basic Login and Product pageobjects because I mostly needed the ability to add a product to my cart and have the ability to log in as an existing test customer. The Checkout pageobject is a little bit more fleshed out, but is by no means all-encompassing. It does allow the test engineer to do a complete checkout as anonymous with a test Mastercard (4111 1111 1111 1111). I tried using other test cards, but I'm guessing that the test Mastercard might be the only one that works in production. There are other registered and anonymous credit card tests that don't actually complete a checkout because of this, but they do step through different checkout flows. There is also a PayPal checkout test that stops at clicking the PayPal button.

All of the tests have assertions to ensure that the test isn't returning false positives and communicates potential issues throughout the test.
