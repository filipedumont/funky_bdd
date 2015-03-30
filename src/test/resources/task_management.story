Feature: Task Management

Meta:


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
When user authenticates on system with username and password
When user clicks on "My Tasks" in "HomePage"
Then user should be on "Tasks" page
When user add new task "YOLO"
Then new task should be created
When user hits "public" on task
Then task is set as "public"

