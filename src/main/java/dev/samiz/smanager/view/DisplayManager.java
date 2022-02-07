package dev.samiz.smanager.view;

import dev.samiz.smanager.model.AvailableSorts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class DisplayManager {
    // For Output.
    StringBuilder builder = new StringBuilder();
    // For Input.
    Scanner scanner = new Scanner(System.in);
    // String for separating the console outputs.
    String separateConsoleOutput = "==========================================";
    // Initialise logger for logging.
    private static Logger logger = LogManager.getLogger("Sort Manager Logger:");

    // Outputs the enums that represent the available sort algorithms that can be used within the program.
    public void outputAvailableSorts(){
        System.out.println("The available sort algorithms are:");
        for (AvailableSorts sorts : AvailableSorts.values()) {
            builder.setLength(0);
            System.out.println(builder.append("> ").append(sorts));
        }
        System.out.println(separateConsoleOutput);
        logger.info("The view has output the available sort algorithms to the console");
    }
    // Outputs a string message to the user in the console followed by a passed in array.
    public void outputArray(int[] arrayToOutput, String message){
        builder.setLength(0);
        for(int i = 0; i < arrayToOutput.length; i++){
            builder.append("Nº" ).append(i+1).append(": ").append(arrayToOutput[i]).append(" | ");
        }
        System.out.println(message);
        System.out.println(builder);
        logger.info("The view has output an array with the message \"" + message + "\" to the console. The array has a length of " + arrayToOutput.length + " .");
        System.out.println(separateConsoleOutput);
    }
    // Outputs a message to the user in the console and requests an int from the user that gets returned.
    public int getDesiredInt (String message){
        System.out.println(message);
        logger.info("The view has requested an int from the console with the message \"" + message + "\".");
        int desiredInt = scanner.nextInt();
        logger.info("The view has received the int " + desiredInt + " from the console.");
        System.out.println(separateConsoleOutput);
        return desiredInt;
    }
    // Outputs a message to the user in the console and requests a string from the user that gets returned.
    public String getDesiredString (String message){
        System.out.println(message);
        logger.info("The view has requested a string from the console with the message \"" + message + "\".");
        String desiredString = scanner.next().toLowerCase();
        logger.info("The view has received the string \"" + desiredString + "\" from the console.");
        System.out.println(separateConsoleOutput);
        return desiredString;
    }
    // Outputs a message with a long and a unit for the number.
    public void outputStatistic(String message, long stat, String unit){
        System.out.println(message + " " + stat + " " + unit);
        logger.info("The view has output a statistic to the console: \"" + message + "\"" + " " + stat + " " + unit);
        System.out.println(separateConsoleOutput);
    }
    // Outputs a message to the user that asks them for input that will be used by the controller to decide on a loop.
    public int getDesireToLoop(){
        System.out.println("Enter an even number to loop the program or and odd number to close it:");
        int loopCommand = scanner.nextInt();
        System.out.println(separateConsoleOutput);
        return loopCommand;
    }
}
