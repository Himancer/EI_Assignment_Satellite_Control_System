# EI_Assignment_Satellite_Control_System

This is a simple Java program that simulates the control of a satellite. It allows you to perform actions such as rotating the satellite's orientation, activating/deactivating solar panels, and collecting data. The program incorporates logging and exception handling for improved code quality and robustness.

## Table of Contents

- [Getting Started](#getting-started)
- [Usage](#usage)
- [Logging](#logging)
- [Exception Handling](#exception-handling)

## Getting Started

To run the Satellite Control System, you'll need to have Java installed on your computer.

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/Himancer/EI_Assignment_Satellite_Control_System.git

2. Navigate to the project directory:

   `cd EI_Assignment_Satellite_Control_System`

3. Compile and run the program:

  `javac Satellite.java`
  `java Satellite`

## Usage
The program provides a menu-driven interface for controlling the satellite. You can choose from the following options:

1. Rotate: Change the satellite's orientation (North, South, East, West).
2. Activate Panels: Activate the solar panels.
3. Deactivate Panels: Deactivate the solar panels.
4. Collect Data: Collect data if the solar panels are active.
5. Exit: Quit the Satellite Control System.

## Logging
The program utilizes Java Util Logging for logging important events and information. Log messages are displayed in the console. The logging levels used are INFO, WARNING, and SEVERE. You can configure the logging behavior by modifying the logging.properties file.

## Exception Handling
The program includes exception handling to gracefully handle potential errors. It catches exceptions such as invalid input and provides appropriate error messages in the log.

