Feature: overdraw
    As a customer
    I want to withdraw from my account using ATM with a negotiated amount specified

Background:
    Given customer with id 1 and pin 111 with balance 200 and negotiated amount is 1000 exists
    And I login to ATM with id 1 and pin 111

Scenario: Overdraw amount less than a negotiated amount specified
    When I overdraw 500 with OD account
    Then my account balance will be 0 with 700 negotiated amount left

Scenario: Overdraw amount more than a negotiated amount specified
    When I exceed negotiated amount by overdraw 5000 with OD account
    Then my account balance will be 200 with 1000 negotiated amount left
