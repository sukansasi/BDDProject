@Login
Feature: BDD_Login with valid and Invalid inputs
  Background:
    Given navigates to Login page

  @positive
  Scenario Outline: BDD_Login with valid inputs

    When I enter "<username>" as username and  "<password>" as password
    And click Login button
    Then navigates to Logged page
    Examples:
    |username                   |password    |
    |sukanyasasi2013@gmail.com  |asdfghj     |


