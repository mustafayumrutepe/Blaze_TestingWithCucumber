Feature:  Go website and SignUp

  Background:
    Given  Navigate to Blaze website

  Scenario: Go website and SingUp And Control
    When Click on the element in LocatorPage
      |SignUp|
    Then Send My Text
      |UserName|KudenCagr|
      |Password|kuden21|
    And Click on the element in LocatorPage
      |SignUpButton|
    And Check the in coming Alert Text
      |Sign up successful.|

  Scenario: Go website and SingUp And Control
    When Click on the element in LocatorPage
      |SignUp|
    Then Send My Text
      |UserName|KudenCagr|
      |Password|kuden21|
    And Click on the element in LocatorPage
      |SignUpButton|
    And Check the in coming Alert Text
      |This user already exist.|