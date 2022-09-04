# Pong
> A simple clone of "Pong" game written in pure Java using "Swing" library.

## Table of Contents
* [General information](#general-information)
* [Used technologies](#used-technologies)
* [Features](#features)
* [Usage](#usage)
* [Credits](#credits)

## General information
- This is a simple application of "Pong" game. It was written in pure Java with the aid of "Swing" library for drawing graphics.
- The project presents my programming skills how I do write code taking care of several optimisations. I did my best to make code follow the SOLID rules.
- The game consists of deflecting the ball by two paddles placed on opposite sides of the field. Players can move their paddles vertically, and they must not let the ball fly to their side of the screen. If this happens, the opponent receives a point. The game ends when any of the players receives sufficient amount of points.
- Win condition: none
- Lose condition: none

## Used technologies
- "IntelliJIDEA" IDE for writing code
- Eclipse Adoptium 17.0.4.1+1 64-bit

## Features
- Resolution: 640x480
- Realtime game loop using thread (used technique from [this link](https://zetcode.com/javagames/animation/ "Java games animation - creating animations in Java 2D"))
- Two players mode
- Scoring system when the ball goes outside the screen
- UI system drawing centered texts in given color
- Adjustable plenty of values in single class

## Usage
- Press W / S keys to control the left paddle
- Press O / L keys to control the right paddle

## Credits
- This project was made by [Jason](https://jasonxiii.pl "Jason. Gry, muzyka, kursy, artykuły, programy i filmy!")