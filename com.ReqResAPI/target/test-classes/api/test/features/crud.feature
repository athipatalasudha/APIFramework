

Feature: Basic CRUD on ReqRes API
  
    Scenario: Successful Login
    
    Given Base URI "https://reqres.in/api/login"
    When User logs in with valid credentials
    Then Valid statuscode "200" is generated
    And Token is generated

    Scenario: UnSuccessful Login
    
    Given Base URI "https://reqres.in/api/login"
    When User logs in with missing password
    Then Valid statuscode "400" is generated
    And Error message "Missing password" is displayed
    
    Scenario: Get SingleUser Details
    
    Given Base URI "https://reqres.in/api/users/2"
    When User requests a single user details
    Then Valid statuscode "200" is generated
    And User details are displayed
    
    Scenario: Get AllUser Details
    
    Given Base URI "https://reqres.in/api/users"
    When User requests all user details
    Then Valid statuscode "200" is generated
    And All User details are displayed
    
    Scenario: Create new User
    
    Given Base URI "https://reqres.in/api/users"
    When user privides new user details to create
    Then Valid statuscode "201" is generated
    And Id id generated for the new user
    
    Scenario: Update User Details
    
    Given Base URI "https://reqres.in/api/users/2"
    When user privides user details to update
    Then Valid statuscode "200" is generated
    And Updated details are displayed