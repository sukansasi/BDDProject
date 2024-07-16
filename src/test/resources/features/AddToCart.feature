Feature: Adding items to the cart
Background:
Given Navigates to login page
  When enter the login details "sukanyasasi2013@gmail.com" , "asdfghj"
  Then User on the Logged Homepage

  Scenario Outline: Add items to the cart and remove all the items from cart
    Given Select the Menu from "<Menu>" and submenu "<Submenu>"
    When Select the item as "<item>"
    Then Add all the items "<item>" to the cart
    And Remove all the items

    Examples:
      |Menu         |Submenu    |  item                      |
      |Computers    |Notebooks  | HP Envy,Asus ,Lenovo Thinkpad        |



