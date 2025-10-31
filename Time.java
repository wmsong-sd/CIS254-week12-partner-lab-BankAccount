/**
   Homework 3
   Description: Replace this with a description of the program here
   @author Wonmin Song
   @since 09/02/2025
*/

public class Time {
    public static void main(String[] args) {
        int hour = Integer.valueOf(args[0]);
        int minute = Integer.valueOf(args[1]);  
        int second = Integer.valueOf(args[2]);
        int numberOfSecs = 24 * 60 * 60;
        int secondsSinceMidnights = hour * 3600 + minute * 60 + second;
        int secondsRemaining = numberOfSecs - secondsSinceMidnights;
        float percentageOftheday = ((float) secondsSinceMidnights / (float) numberOfSecs) * 100;
        System.out.println("Number of seconds in a day: " + numberOfSecs);
        System.out.println("Seconds sinece midnights: " + secondsSinceMidnights);
        System.out.println("Seconds remaining in a day: " + secondsRemaining);
        System.out.printf("Percentage of the day that has passed: %.2f%%%n", percentageOftheday);

    }
}