Feature: Uploading files and pictures as messages
  As a user, I should be able to upload files and pictures as messages

  @AC1
  Scenario: Uploading multiple files at the same time (Test with max 3 files.)
    Given user is on homepage
    And user clicks on Message
    When User clicks on the Upload Files and Images box
    And User chooses three files from their computer
    Then Files are uploaded as attachments for the message
    And user clicks on send button
    Then user sees the document attached


  @AC2-a
  Scenario: Uploading different types of files each time (word)
    Given user is on homepage
    And user clicks on Message
    When User clicks on the Upload Files and Images box
    And User chooses word document
    And Files are uploaded as attachments for the message
    And user clicks on send button
    Then user sees the document attached

  @AC2-b
  Scenario: Uploading different types of files each time (pdf)
    Given user is on homepage
    And user clicks on Message
    When User clicks on the Upload Files and Images box
    And User chooses pdf document
    And Files are uploaded as attachments for the message
    And user clicks on send button
    Then user sees the document attached

  @AC2-c
  Scenario: Uploading different types of files each time (jpeg)
    Given user is on homepage
    And user clicks on Message
    When User clicks on the Upload Files and Images box
    And User chooses jpeg document
    And Files are uploaded as attachments for the message
    And user clicks on send button
#Then user sees the document attached

  @AC2-d
  Scenario: Uploading different types of files each time (png)
    Given user is on homepage
    And user clicks on Message
    When User clicks on the Upload Files and Images box
    And User chooses png document
    And Files are uploaded as attachments for the message
    And user clicks on send button
#Then user sees the document attached

  @AC2-e
  Scenario: Uploading different types of files each time (txt)
    Given user is on homepage
    And user clicks on Message
    When User clicks on the Upload Files and Images box
    And User chooses txt document
    And Files are uploaded as attachments for the message
    And user clicks on send button
#Then user sees the document attached


  @AC2-f
  Scenario: Uploading different types of files each time (gif)
    Given user is on homepage
    And user clicks on Message
    When User clicks on the Upload Files and Images box
    And User chooses gif document
    And Files are uploaded as attachments for the message
    And user clicks on send button
#Then user sees the document attached

  @AC5-a
  Scenario: Inserting files in message (docx)
    Given user is on homepage
    And user clicks on Message
    When user types something
    When User clicks on the Upload Files and Images box
    And User chooses word document
    And user clicks on insert in text button
    And Files are uploaded inside the message
    And user clicks on send button
#Then user sees the document attached

  @AC5-b
  Scenario: Inserting files in message (gif)
    Given user is on homepage
    And user clicks on Message
    When user types something
    When User clicks on the Upload Files and Images box
    And User chooses gif document
    And user clicks on insert in text button
    And Files are uploaded inside the message
    And user clicks on send button
#Then user sees the document attached

  @AC6
  Scenario: Allowing other users to edit attachments
    Given user is on homepage
    And user clicks on Message
    When User clicks on the Upload Files and Images box
    And User chooses png document
    And user verifies that Allow a recipient to edit documents? box is already checked
    And user clicks on send button
#Then user sees the document attached

  @AC7
  Scenario: Removing attached attachments
    Given user is on homepage
    And user clicks on Message
    When user types something
    When User clicks on the Upload Files and Images box
    And User chooses jpeg document
    And user clicks on X button
    And user clicks on send button
#Then user sees the document attached

  @AC8
  Scenario: Renaming attached file
    Given user is on homepage
    And user clicks on Message
    When User clicks on the Upload Files and Images box
    And User chooses png document
    And user hovers over file name and clicks on the pen icon
    And user changes the name of the document
    And user clicks on send button
#Then user sees the document attached
