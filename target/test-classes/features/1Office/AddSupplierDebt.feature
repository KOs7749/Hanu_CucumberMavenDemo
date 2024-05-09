Feature: Supplier Debt Management
  As a user, I want to be able to create new debt for my suppliers.
  So I can add information and manage suppliers' debt

  Scenario: Test redirecting to the supplier details screen
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I click submenu "Nha cung cap"
    When I click on the supplier code
    Then I should be taken to the page Supplier Detail

  Scenario: Test opening a pop-up to add new debt to the supplier
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I click submenu "Nha cung cap"
    And I click on the supplier code
    Then I should be taken to the page Supplier Detail
    When I hover icon "Công nợ", click "Ghi nợ"
    Then I should see a pop-up to add new debt to the supplier

  Scenario: Test adding new debt to the supplier successfully
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I click submenu "Nha cung cap"
    And I click on the supplier code
    And I hover icon "Công nợ", click "Ghi nợ"
    When I enter valid fields for adding new debt
    And I click on button "Update"
    Then I should see the debt was added successfully

  Scenario: Test adding new debt to supplier when only entering the required field [Date]
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I click submenu "Nha cung cap"
    And I click on the supplier code
    And I hover icon "Công nợ", click "Ghi nợ"
    When I enter only the required field [Date], and leave other fields blanks
    And I click on button "Update"
    Then I should see an error message indicating that [Money] and [Reason] fields are missing

  Scenario: Test adding new debt to supplier when only entering the required field [Money]
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I click submenu "Nha cung cap"
    And I click on the supplier code
    And I hover icon "Công nợ", click "Ghi nợ"
    When I enter only the required field [Money], and leave other fields blanks
    And I click on button "Update"
    Then I should see an error message indicating that [Date] and [Reason] fields are missing

  Scenario: Test adding new debt to supplier when only entering the required field [Reason]
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I click submenu "Nha cung cap"
    And I click on the supplier code
    And I hover icon "Công nợ", click "Ghi nợ"
    When I enter only the required field [Reason], and leave other fields blanks
    And I click on button "Update"
    Then I should see an error message indicating that [Date] and [Money] fields are missing

  Scenario: Test adding new debt to supplier without entering any required fields
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I click submenu "Nha cung cap"
    And I click on the supplier code
    And I hover icon "Công nợ", click "Ghi nợ"
    When I do not enter any required fields
    And I click on button "Update"
    Then I should see error messages indicating that all required fields are missing

  Scenario: Test adding new debt to supplier when entering incorrect date format
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I click submenu "Nha cung cap"
    And I click on the supplier code
    And I hover icon "Công nợ", click "Ghi nợ"
    When I enter an incorrect date format
    And I click on button "Update"
    Then I should see an error message indicating that the date format is incorrect

  Scenario: Test adding new debt to supplier when entering > 300 characters at [Reason] field
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I click submenu "Nha cung cap"
    And I click on the supplier code
    And I hover icon "Công nợ", click "Ghi nợ"
    When I enter more than 300 characters in the [Reason] field
    And I click on button "Update"
    Then I should see an error message indicating that the reason field exceeds the character limit

  Scenario: Test cancel adding new debt to supplier
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I click submenu "Nha cung cap"
    And I click on the supplier code
    And I hover icon "Công nợ", click "Ghi nợ"
    When I decide to cancel adding new debt
    Then The pop-up should be closed
