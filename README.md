# Cameo/MagicDraw plugin development - Lesson 4

This is the fourth lesson of the series. In this lesson we will learn how to work with diagrams.

Reference documentation:

* https://docs.nomagic.com/display/MD2021xR2/Working+with+diagrams

# Requirements

- Cameo/MagicDraw latest
- Java JDK 11
- Maven

# Usage

## Check out the repository

`git clone https://github.com/modeldriven-hu/cameo_lesson_4.git`

## Configure environment variable

Configure Cameo/MagicDraw root directory according to local setup, for example:

`set CAMEO_ROOT=C:/home/Tools/Cameo`

or when using PowerShell:

`$env:CAMEO_ROOT = "C:/Home/Tools/Cameo"`

## Build project

`mvn package`

## Extract into Cameo plugins folder

Extract `target/hu.modeldriven.cameo.lesson4.zip` into `CAMEO_ROOT/plugins`

## Restart

Restart CAMEO

# Configure javadoc for IntelliJ

![image](https://user-images.githubusercontent.com/8182138/179385202-9dc9e4cf-e79a-4cd2-bc2f-19ac3f2ba04c.png)

