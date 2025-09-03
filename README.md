# Lab 2

## Requirements
- Eric Taylor 20707455
- Attempting: A

## Running Program
1. `javac StudentManager.java`
2. `java StudentManager hogwarts.csv`

## AI Use
None

## Challenges
The scanner used in main was throwing `NoSuchElementException`, caused
by the scanner being closed prematurely. This was solved by passing the 
instance scanner to each function that needs it and closing it after.