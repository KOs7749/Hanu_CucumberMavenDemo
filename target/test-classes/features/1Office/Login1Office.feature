Feature: Login to CRM
  As a user, I want to be able to log into the 1Office system
  So that I can manage Post information

  Scenario: User views the login page UI elements
    Given I am on the login page
    Then I should see login page UI

  Scenario: Login success
    Given I am on the login page
    When I enter my username and password
    And I click the Login button
    Then I should be taken to the dashboard page
    And I should see the "Bang tin" menu

  Scenario: Login fail with invalid username
    Given I am on the login page
    When I enter invalid username and password correct
    And I click the Login button
    Then I should see the error message
    And I should be taken to the Login page

  Scenario: Login fail with invalid password
    Given I am on the login page
    When I enter correct username and invalid password
    And I click the Login button
    Then I should see the error message
    And I should be taken to the Login page

  Scenario: Login fail with invalid username and password
    Given I am on the login page
    When I enter username and password invalid
    And I click the Login button
    Then I should see the error message
    And I should be taken to the Login page

  Scenario: Login with SQL Injection
    Given I am on the login page
    When I enter username and password with SQL injection
    And I click the Login button
    Then I should see the error message
    And I should be taken to the Login page
    
  Scenario: User clicks on the forgot password link
    Given I am on the login page
    When I clicks on the forgot password link
    Then I should see the recovery password screen




