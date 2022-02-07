package dev.samiz.smanager;

import dev.samiz.smanager.controller.SortManager;

public class SortManagerMain {
    public static void main(String[] args){
        // Initialising the Controller.
        SortManager controller = new SortManager();
        // Executing the program by calling the method from the controller.
        controller.executeProgramLoop();
    }
}
