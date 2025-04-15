# Java Multithreading - Word Counter

A simple Java application that demonstrates multithreading capabilities by counting word occurrences in text files.

## Project Overview

This repository contains a parallel word counting implementation that:
- Processes text files to count specific word occurrences
- Uses Java's concurrent utilities (ExecutorService, Future, Callable)
- Measures and reports execution time

## Key Features

- Thread-based text processing
- File I/O operations with BufferedReader
- Concurrent task execution with ExecutorService
- Word counting using Java 8 Stream API

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Visual Studio Code with Java extensions

### Folder Structure
- `src`: Contains source code files
- `lib`: For external dependencies
- `bin`: Compiled output (generated automatically)

## Usage

The current implementation processes a file at `D:\java\multithreading\java.txt` and counts occurrences of the word "Java".

To run the application:
1. Open the project in VS Code
2. Run the `ParallelWordCounter.java` file

## Future Improvements

- Accept command-line arguments for file path and search term
- Support multiple files processing in parallel
- Implement more advanced text processing features

## Dependencies

The project relies on standard Java libraries with no external dependencies.
