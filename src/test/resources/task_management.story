Feature: Task Management

Narrative:
As an user
I want to be able to manage my tasks
So that I can display them on screen

!-- THIS WON'T WORK ON JBEHAVE
!-- Background:
!-- Given user is on "HomePage"
!-- When user authenticates on system with "username" and "password"

Scenario: Add a new public Task
Given user is on HomePage
When user authenticates on system with ffranca@avenuecode.com and test12345
When user clicks on My Tasks in HomePage
Then user should be on TaskPage
When user adds new task YOLO
Then new task YOLO should be created
When user hits public on YOLO task
Then YOLO task is set as public


Scenario: Add a subtask for a new task
Given I am on HomePage
When user authenticates on system with ffranca@avenuecode.com and test12345
When user clicks on My Tasks in HomePage
Then user should be on TaskPage
When user adds new task UMAD BRO
Then new task UMAD BRO should be created
When user clicks on Manage Subtasks in TaskPage
And user add "NO I'M NOT" as subtask
Then new subtask should be created