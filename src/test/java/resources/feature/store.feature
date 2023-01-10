Feature: Testing different request on the best buy api

  As a user I want to test if data can be accessed, created,updated and deleted on the best buy store api

  Background: Best buy api is running

  Scenario: Check if the best buy store api can be accessed by users
    When  I send a GET request to stores endpoint
    Then  I must get back a valid status code "200"

  Scenario: Check if a new store can be created on the best buy store api
    When  I send a POST request to stores endpoint with the information name "Matlab" type "T8" address "Sherman" address2 "Sherman Avenue" city "Los Angeles" state "California" zip "98568" lat "33.584" lng "114.587" hours "Mon-Sat 8.00am to 8.00pm" service1 "service id" service2 "Not available"
    Then  I must get back a valid status code "201"


  Scenario: Check if the best buy store api can be accessed by users by searching store by ID
    When  I send a GET request to single storeID endpoint
    Then  I must get back a valid status code "200"


  Scenario: Check if the best buy store api can be updated by users by searching store by ID
    When  I send a PUT request to single storeID endpoint with updated information name "Matlab" type "T8" address "Sherman" address2 "Sherman Avenue" city "Los Angeles" state "California" zip "98568" lat "33.584" lng "114.587" hours "Mon-Sat 8.00am to 8.00pm" service1 "service id" service2 "Not available"
    Then  I must get back a valid status code "200"


  Scenario: Check if the users can delete the store by searching store by ID
    When  I send a DELETE request to single storeID endpoint
    Then  I must get back a valid status code "200"

