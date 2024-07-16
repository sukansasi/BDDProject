Feature: Checkout



    Scenario Outline: CheckOut
      Given Login using "<userName>", "<password>" and Add the items to the cart using "<menu>", "<subMenu>","<Items>"
      When Select Checkout and Enter the Billing details "<firstName>","<lastName>","<email>","<Country>","<City>","<Address1>","<postalCode>","<phoneNum>"
      And Select shipping method "<SM>", payment method "<PM>" and confirm order
      Then Order placed Successfully
      Examples:
        |userName  | password   |menu|subMenu|Items    |firstName  |lastName | email| Country |City| Address1| postalCode|phoneNum|SM|PM|
        |iamdsasi@gmail.com| lkjhgf   |Computers |Notebooks|HP Envy,Asus ,Lenovo Thinkpad     |firstName  |lastName | sukanyasasi2013@gmail.com| United Kingdom |Manchester| 40, Brooks Road| M20 2TX|7489563249|Next Day Air|Check|