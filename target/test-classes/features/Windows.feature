Feature: Click tab on parent page

Scenario: Parent page click
Given User is on parent page
When User clicks on open tab button
And navigates from parent page to child page and should contain text
Then child page is displayed and reads information "info@qaclickacademy.com"

