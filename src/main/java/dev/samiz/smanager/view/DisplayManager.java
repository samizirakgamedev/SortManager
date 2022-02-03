package dev.samiz.smanager.view;

import dev.samiz.smanager.model.AvailableSorts;
import java.util.Scanner;

public class DisplayManager {
    // For Output.
    StringBuilder builder = new StringBuilder();
    // For Input.
    Scanner scanner = new Scanner(System.in);
    // String for separating the console outputs.
    String separateConsoleOutput = "==========================================";
    // Outputs the enums that represent the available sort algorithms that can be used within the program.
    public void outputAvailableSorts(){
        System.out.println("The available sort algorithms are:");
        for (AvailableSorts sorts : AvailableSorts.values()) {
            builder.setLength(0);
            System.out.println(builder.append("> ").append(sorts));
        }
        System.out.println(separateConsoleOutput);
    }
    // Outputs a string message to the user in the console followed by a passed in array.
    public void outputArray(int[] arrayToOutput, String message){
        builder.setLength(0);
        for(int i = 0; i < arrayToOutput.length; i++){
            builder.append("Nº" ).append(i+1).append(": ").append(arrayToOutput[i]).append(" | ");
        }
        System.out.println(message);
        System.out.println(builder);
        System.out.println(separateConsoleOutput);
    }
    // Outputs a message to the user in the console and requests an int from the user that gets returned.
    public int getDesiredInt (String message){
        System.out.println(message);
        int desiredInt = scanner.nextInt();
        System.out.println(separateConsoleOutput);
        return desiredInt;
    }
    // Outputs a message to the user in the console and requests a string from the user that gets returned.
    public String getDesiredString (String message){
        System.out.println(message);
        String desiredString = scanner.next().toLowerCase();
        System.out.println(separateConsoleOutput);
        return desiredString;
    }
}
