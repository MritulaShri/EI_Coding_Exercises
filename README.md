# EI_Coding_Exercises

# EXERCISE-1

# Design patterns

Each design pattern is illustrated with a simple, yet illustrative use case. The design patterns covered are categorized into behavioral, creational, and structural patterns.

## Behavioral Design Patterns

### Strategy Pattern

Use Case: Payment processing system that can handle different types of payment methods (Credit Card, PayPal, Bitcoin).

### Observer Pattern

Use Case: A weather monitoring system where different devices (Phone, Computer, Tablet) receive updates when the weather changes.

## Creational Design Patterns

### Singleton Pattern

Use Case: Logger class that ensures only one instance is used throughout the application.

### Factory Pattern

Use Case: Creating different types of documents (Word, PDF, Excel).

## Structural Design Patterns

### Adapter Pattern

Use Case: Connecting a US power plug to an EU power socket.

### Decorator Pattern

Use Case: Adding functionalities (Border, Scroll) to a TextView in a graphical user interface.

# EXERCISE-2

# Astronaut Daily Schedule Organizer

The Astronaut Daily Schedule Organizer is a console-based application designed to help astronauts manage their daily tasks. The application supports adding, removing, viewing, and editing tasks, with additional features such as task prioritization and conflict detection.

## Features

- Add Task: Add a new task with a description, start time, end time, and priority level.
- Remove Task: Remove an existing task by its description.
- View Tasks: View all tasks sorted by start time.
- Edit Task: Edit an existing task's details.
- Mark Task as Completed: Mark a task as completed.
- View Tasks by Priority: Filter and view tasks by their priority level.
- Conflict Detection: Ensure new tasks do not overlap with existing tasks.
- Notifications: Notify users of task conflicts.

## Design Patterns Used

- Singleton Pattern: Ensures there is only one instance of the schedule manager.
- Factory Pattern: Creates task objects.
- Observer Pattern: Notifies users of task conflicts.

### Running the Application

- Run the `AstronautScheduleApp` class from your IDE.

### Usage

The application supports the following commands:

- Add Task: Add a new task.
- Remove Task: Remove an existing task by its description.
- View Tasks: View all tasks sorted by start time.
- Edit Task: Edit an existing task's details.
- Mark Task as Completed: Mark a task as completed.
- View Tasks by Priority: Filter and view tasks by their priority level.

