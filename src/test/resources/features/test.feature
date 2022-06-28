Feature: Uploading files and pictures as messages
  As a user, I should be able to upload files and pictures as messages

  @wip
  Scenario: Uploading multiple files at the same time (Test with max 3 files.)
    Given user is on homepage
    And user clicks on Message
    When User clicks on the Upload Files and Images box
    And User chooses three files from their computer
    And User clicks on Open
    Then Files are uploaded as attachments for the message

