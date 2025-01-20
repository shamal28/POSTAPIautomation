Feature: add product using POST API call
Scenario Outline: To validate post ecommerce api response body and status code
    Given user hits the url of POST API endpoint
    When user passes the details of products in the request
    And user passes the request body for title of the product <ProductTitle>
    Then user should get the response code as 200 and new id for the added product
    Examples:
      | ProductTitle |
      | Watch       |

 