Feature: Automation of AdactinHotel

  Scenario Outline: Entering all Feilds to Book
    # Given User is on the Adactin page
    # When User should perform login
    And User Should Verify login msg "Hello sarathkumare!"
    And User should Search Hotel with selecting "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>"and"<childrensPerRoom>"
    And User Should Verify select hotel "Select Hotel"
    And User should select Hotel
    And User Should Verify msg "Book A Hotel"
    And User should book hotel with giving details"<firstName>","<lastName>","<address>" and payment
      | cardType         | cardNo           | select month | select value | cvv  |
      | American Express | 9084567890123456 | January      |         2022 | 1234 |
      | VISA             | 9084567890124532 | April        |         2022 | 4321 |
      | American Express | 9084654387123456 | May          |         2022 | 8765 |
    Then User Should Verify "Booking Confirmation"

    Examples: 
      | location    | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom | firstName | lastName | address |
      | Los Angeles | Hotel Creek | Standard | 3 - Three | 26/05/2022  | 27/05/2022   | 1 - One       | 0 - None         | balaji    | k        | Mumbai  |

  Scenario Outline: Without Entering book hotel Field ,click book
    #Given User is on the Adactin page
    # When User should perform login
    And User Should Verify login msg "Hello sarathkumare!"
    And User should Search Hotel with selecting "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>"and"<childrensPerRoom>"
    And User Should Verify select hotel "Select Hotel"
    And User should select Hotel
    And User Should Verify msg "Book A Hotel"
    And User Should click book button
    Then User Should verify msg "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month","Please Enter your Credit Card CVV Number"

    Examples: 
      | location    | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom |
      | Los Angeles | Hotel Creek | Standard | 3 - Three | 26/05/2022  | 27/05/2022   | 1 - One       | 0 - None         |
