Feature: Make a coffee with a complete espresso coffee machine
  A user want an espresso
  Scenario: A user plugs the espresso coffee machine and makes a coffee Arabica-Crema
    Given an espresso coffee machine with 0.10 l of min capacity, 3.0 l of max capacity, 600.0 l per h of water flow for the pump
    And a "mug" with 0.25 l of capacity
    When I plug the espresso machine to electricity
    And I add 1 l of water in the water tank
    And I add 0.5 l of "ARABICA_CREMA" in the bean tank
    And I made an espresso coffee "ARABICA_CREMA"
    Then the espresso coffee machine return a coffee mug not empty
    And the coffee volume equals to 0.25
    And the coffee "mug" containing a coffee type "ARABICA_CREMA"