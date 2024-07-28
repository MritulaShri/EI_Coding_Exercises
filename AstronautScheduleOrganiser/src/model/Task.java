package model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task {
//    private String description;
//    private String startTime;
//    private String endTime;
//    private String priority;
//    private boolean isCompleted;
//
//    public Task(String description, String startTime, String endTime, String priority) {
//        this.description = description;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.priority = priority;
//        this.isCompleted = false;
//    }
//
//    // Getters and Setters
//    public String getDescription() { return description; }
//    public void setDescription(String description) { this.description = description; }
//    public String getStartTime() { return startTime; }
//    public void setStartTime(String startTime) { this.startTime = startTime; }
//    public String getEndTime() { return endTime; }
//    public void setEndTime(String endTime) { this.endTime = endTime; }
//    public String getPriority() { return priority; }
//    public void setPriority(String priority) { this.priority = priority; }
//    public boolean isCompleted() { return isCompleted; }
//    public void setCompleted(boolean isCompleted) { this.isCompleted = isCompleted; }
//
//    @Override
//    public String toString() {
//        return startTime + " - " + endTime + ": " + description + " [" + priority + "]";
//    }
	
	private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priority;
    private boolean isCompleted;

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = LocalTime.parse(startTime, TIME_FORMATTER);
        this.endTime = LocalTime.parse(endTime, TIME_FORMATTER);
        this.priority = priority;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean conflictsWith(Task other) {
        return (this.startTime.isBefore(other.endTime) && this.endTime.isAfter(other.startTime));
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s] %s",
                startTime.format(TIME_FORMATTER),
                endTime.format(TIME_FORMATTER),
                description,
                priority,
                isCompleted ? "(Completed)" : "");
    }
}
