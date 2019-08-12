# filename: features/user_login.feature

Feature: User goes to login from homepage

  Scenario: Customer visits AEO homepage and logs in to their account
    Given Customer is at AEO homepage and global controls are visible
    And Customer clicks global account link
    Then Customer sees Account flyout from the right side of the browser
