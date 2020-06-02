Feature: Verify Mindtrans E2E functionality

Scenario Outline: Successful Payment Flow

Given user launch "https://demo.midtrans.com/"
When click on "BUY NOW" button
And enter amount as "<new_amount>" inspite of "<amount>"
And enter name as "<name>" inspite of "Budi"
And email as "<email>" inspite of "budi@utomo.com"
And phone number as "<phone_number>" inspite of "081808466410"
And city as "<city>" inspite of "Jakarta"
And address as "<address>" inspite of "MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11"
And postalcode as "<postalcode>" inspite of "10220"
And click on "CHECKOUT" button
Then click on "Continue" button
Then select payment option as "Credit Card"
And enter the "<card_number>" in "Card number" field
And enter the "<expiry_date>" in "MM/YY" field
And enter the "<cvv>" in "CVV" field
Then click on "PAYNOW" button


Examples:
	#User Data
	|amount| new_amount |name  | email                   | phone_number | city | address | postalcode | item			 	|card_number 			| expiry_date | cvv | 
	|20000 | 40000		|mayur | mayursapre.ms@gmail.com | 9876543210   | Pune | Baner   | 411045 	  | Midtrans Pillow	    |4811 1111 1111 1114	|  05/20	  | 123 |
	
	
Scenario Outline: Failed Payment Flow

Given user launch "https://demo.midtrans.com/"
When click on "BUY NOW" button
And enter amount as "<new_amount>" inspite of "<amount>"
And enter name as "<name>" inspite of "Budi"
And email as "<email>" inspite of "budi@utomo.com"
And phone number as "<phone_number>" inspite of "081808466410"
And city as "<city>" inspite of "Jakarta"
And address as "<address>" inspite of "MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11"
And postalcode as "<postalcode>" inspite of "10220"
And click on "CHECKOUT" button
Then click on "Continue" button
Then select payment option as "Credit Card"
And enter the "<card_number>" in "Card number" field
And enter the "<expiry_date>" in "MM/YY" field
And enter the "<cvv>" in "CVV" field
Then click on "PAYNOW" button

Examples:
	#User Data
	|amount| new_amount |name  | email                   | phone_number | city | address | postalcode | item			 	|card_number 			| expiry_date | cvv | 
	|20000 | 40000		|mayur | mayursapre.ms@gmail.com | 9876543210   | Pune | Baner   | 411045 	  | Midtrans Pillow	    |4911 1111 1111 1113	|  05/20	  | 123 |
