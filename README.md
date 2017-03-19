<br>ELENE 4901 Project 1 Report
<br>Date: March 20th 2017
<br>Team Leader: Tianhua Fang – tf2377
<br>Team Member: Edwin Chan – cc3919

## Introduction
The project contains two android games. Cat-Rat-elephant is modified based on the Rock-Paper-Scissors Game Design tutorial, which is to complete the basic phase for the project. Then we extend the game to have 5 options in order to make it more fair and competitive, which is called Rock-Paper-Scissors-Lizard-Spock. For both games, users can see the game statistic. And for Cat-Rat-elephant game,we also implement a cheating mode so that user can see what choice that PC will made.  What’s more, we add background music, button clicking sound effect, background image, and button images to improve the UI and user experiences.


## New Features
- There are several new features implement to the system. 
- Cheat button in basic game mode
- Advanced game mode
- Sound effect
- Reset button

Cheat Button in basic game mode
In the interface of the basic game mode, there is a cheat button. Pressing that button will display the the computer’s choice of the animal. Player can change the choice according to computer’s choice.

Advanced game mode
An extended version of the rock-paper-scissor, it have five different choice. Each choice are related with other in a particular way. Details of the relationship is stated in the rule button in the game interface.

Sound effect
Both basic game mode and advanced game mode have background music. Also each button have its own sound effect.

Reset button
This button allow users to reset all the data, including Round#, win and win rate.

## Techniques and project layout

The app contains four activities, and they are mainActivity, RPS_main, AdvancedGame, and rule_advanced. The mainActivity is the entrance for the app, users can choose which game they want to play. The RPS_main activity is for the Cat-Rat-Elephant game, the UI contains three image button for user’s choice, and two image views for the output display, 4 text fields to show the game result and game statistics. Cheat button allows user to use the cheating mode for one round, and rest button will reset all game statistics. The AdvancedGame is the activity for Rock-Paper-Scissors-Lizard-Spock game. It has the similar UI arrangement as the RPS_main, but there is no cheat function for user to win easily. What’s more there is a button to initiate the rule_advanced activity to read the rule for this advanced game. 

We use Android studio and Android SDK only for this project. The development environment is Android 5.0 API25. All the activities are relative layout so that it can fit most of the phone screen sizes. We tested for 3.3”, 3.4”, 4.0”, 4.1”, 4.3” of screen sizes and all their UI’s are fit. We also test on the models we have, which is Huawei P9 (Android 6.0 API 23) and HTC Desire 820, and both pass the test. 

Sound effects are added to the game with MediaPlayer. The media player is instantiated each time the button is clicked. The media player for bgm is created during the OnCreate state of the activity.

The cheat button will first run the math.rand to generate computer’s choice and display pc imageview. That number will be passed to the button OnClickListener, which will allows the player to choose the correct answer.
