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

    public void outputAvailableSorts(){
        System.out.println("The available sort algorithms are:");
        for (AvailableSorts sorts : AvailableSorts.values()) {
            builder.setLength(0);
            System.out.println(builder.append("> ").append(sorts));
        }
        System.out.println(separateConsoleOutput);
    }
    public void outputArray(int[] arrayToOutput, String message){
        builder.setLength(0);
        for(int i = 0; i < arrayToOutput.length; i++){
            builder.append("Nº" ).append(i+1).append(": ").append(arrayToOutput[i]).append(" | ");
        }
        System.out.println(message);
        System.out.println(builder);
        System.out.println(separateConsoleOutput);
    }
    public int getDesiredInt (String message){
        System.out.println(message);
        int desiredInt = scanner.nextInt();
        System.out.println(separateConsoleOutput);
        return desiredInt;
    }
    public String getDesiredString (String message){
        System.out.println(message);
        String desiredString = scanner.next().toLowerCase();
        System.out.println(separateConsoleOutput);
        return desiredString;
    }
}
