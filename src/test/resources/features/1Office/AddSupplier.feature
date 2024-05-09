Feature: Add Supplier
  As a user, I want to be able to create new providers.
  So I can add information and manage suppliers

  Scenario: Open screen add supplier
    Given I am logged in successfully
    And I select menu "Mua hang"
    When I select item "Nha cung cap"
    Then I should be taken to the page Add Supplier

  Scenario: Add new supplier successfully
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I select item "Nha cung cap"
    Then I should be taken to the page Add Supplier
    When I enter valid all fields
    And I click the button "Cap nhat"
    Then I should be taken to the page Supplier Detail

  Scenario: Add new supplier when only entering the required field [Full name]
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I select item "Nha cung cap"
    Then I should be taken to the page Add Supplier
    When I enter valid Full name field, and leave other fields blank
    And I click the button "Cap nhat"
    Then I should see error message 'Loại nhà cung cấp chưa nhập Mã nhà cung cấp chưa nhập'

  Scenario: Add new supplier when only entering the required field [Supplier Code]
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I select item "Nha cung cap"
    Then I should be taken to the page Add Supplier
    When I enter valid Supplier Code field, and leave other fields blank
    And I click the button "Cap nhat"
    Then I should see error message 'Loại nhà cung cấp chưa nhập Tên khách hàng bắt buộc phải nhập'

  Scenario: Add new supplier when only entering the required field [Supplier type]
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I select item "Nha cung cap"
    Then I should be taken to the page Add Supplier
    When I enter valid Supplier Type field, and leave other fields blank
    And I click the button "Cap nhat"
    Then I should see error message 'Mã nhà cung cấp chưa nhập Tên khách hàng bắt buộc phải nhập'

  Scenario: Add new supplier without entering any required fields
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I select item "Nha cung cap"
    Then I should be taken to the page Add Supplier
    When I leave all fields blank
    And I click the button "Cap nhat"
    Then I should see error message 'Mã nhà cung cấp chưa nhập Tên khách hàng bắt buộc phải nhập Loại nhà cung cấp chưa nhập'

  Scenario: Add new supplier when entering incorrect phone number format
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I select item "Nha cung cap"
    Then I should be taken to the page Add Supplier
    When I enter invalid phone number format
    And I click the button "Cap nhat"
    Then I should see error message indicating incorrect phone number format

  Scenario: Add new supplier when entering incorrect email format
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I select item "Nha cung cap"
    Then I should be taken to the page Add Supplier
    When I enter invalid email format
    And I click the button "Cap nhat"
    Then I should see error message indicating incorrect email format

  Scenario: Add new supplier when entering incorrect date of birth format
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I select item "Nha cung cap"
    Then I should be taken to the page Add Supplier
    When I enter invalid date of birth format
    And I click the button "Cap nhat"
    Then I should see error message indicating incorrect date of birth format

  Scenario: Add new supplier when entering incorrect id of date format
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I select item "Nha cung cap"
    Then I should be taken to the page Add Supplier
    When I enter invalid id of date format
    And I click the button "Cap nhat"
    Then I should see error message indicating incorrect id of date format

  Scenario: Cancel adding new supplier
    Given I am logged in successfully
    And I select menu "Mua hang"
    And I select item "Nha cung cap"
    Then I should be taken to the page Add Supplier
    When I click on the button 'Hủy bỏ'
    Then I should be redirected to the previous page without adding a new supplier


