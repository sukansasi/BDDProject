
@Registration
Feature: BDD_Registration with valid and Invalid inputs
Background:
  Given navigates to Registration page

@positive
  Scenario Outline: BDD_Registration with valid inputs
  When Fill the Registration form with details "<Gender>","<First Name>","<Last Name>","<Date>" ,"<Month>","<Year>","<Email>","<Password>" ,"<Confirm password>"
  And click Register button
  Then Display success message

  #Change the email id if you are running the program continuously for valid inputs only.
        # otherwise it will display the error msg that "Specified email already exists"
    Examples:
    |Gender | First Name |Last Name | Date | Month | Year |Email                     | Password   |Confirm password |
    |Female | Sukanya   |Sasikumar  |10    |    10 |1990  |sukanyasasi2013@gmail.com| asdfghj    |asdfghj          |
    |Male   | Sasi      |Kumar      |15    |    12 |2000  |iamdsasi@gmail.com       |lkjhgf      |lkjhgf           |
@negative
Scenario Outline: BDD_Registration with invalid inputs
  When Fill the Registration form with details "<Gender>","<First Name>","<Last Name>","<Date>" ,"<Month>","<Year>","<Email>","<Password>" ,"<Confirm password>"
  And click Register button
  Then Display error message
  Examples:

    |Gender | First Name |Last Name | Date | Month | Year |Email                | Password   |Confirm password |
    |Female |   Sukan    |Sasikumar |10    |    10 |1990  | uansas2013@gmail.com | asdfghj    |asdfgjkljl       |
    |Female |   Sukan    |Sasikumar |10    |    10 |1990  |suansas2013@gmail.com|            |                 |
    |Male   | Sasi       |          |15    |    12 |2000  |idsasi@gmail.com     |lkjhgf      |lkjhgf           |
    |Male   | Sasi       |  Kumar   |15    |    12 |2000  |                     | lkjhgf     |  lkjhgf         |
    |Male   |            |  Kum     |15    |    12 |2000  |                     |lkjhgf      |lkjhgf           |
    |Female |   Sukan    |Sasikumar |10    |    10 |1990  |ukansas2013@gmail.com| as   |as       |
    |Male   |            |          |15    |    12 |2000  |imdsasi@gmail.com    |lkjhgf      |lkjhgf           |