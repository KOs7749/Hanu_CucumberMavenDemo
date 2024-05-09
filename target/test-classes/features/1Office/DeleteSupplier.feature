Feature: Delete supplier from Supplier List
  As a user, I want to navigate to the supplier list page
  So that I can delete supplier


  Scenario: Open page Supplier List
    Given I am logged in successfully
    And I select menu "Mua hang"
    When I click submenu "Nha cung cap"
    Then I should be taken to the page Supplier List

  Scenario: Delete a single supplier
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I click submenu "Nha cung cap"
    Then I should be taken to the page Supplier List
    When I select one supplier checkbox
    And I click delete icon
    And I click button Update
    Then I should see a supplier deleted successfully


  Scenario: Delete multiple suppliers
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I click submenu "Nha cung cap"
    Then I should be taken to the page Supplier List
    When I select more than one supplier checkbox
    And I click delete icon
    And I click button Update
    Then I should see suppliers deleted successfully

  Scenario: Cancel delete operation
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I click submenu "Nha cung cap"
    Then I should be taken to the page Supplier List
    When I select one supplier checkbox
    And I click delete icon
    And I click button Cancel
    Then I should see that supplier still exists in the list
