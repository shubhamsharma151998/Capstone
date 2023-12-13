Feature: Verify Few hyperlinks Functionality

Scenario: Navigates to Different Hyperlink and perform few actions
Given User navigates to HomePage and Click on A/B Testing link
Then Navigates Back to HomePage and click on dropdown link
And Select option1 value from the dropdown
Then Confirm whether it is selected or not
And Navigates back to HomePage and Click on Frames
Then Verify it contain Nested Frames and iFrames hyperlink on the Frame Page 