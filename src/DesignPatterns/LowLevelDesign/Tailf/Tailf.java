package DesignPatterns.LowLevelDesign.Tailf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tailf {
    static long sleepTime;

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args.length > 1) sleepTime = Long.parseLong(args[1]) * 1000;
            try {
                BufferedReader input = new BufferedReader(new FileReader(args[0]));
                String currentLine = null;
                while (true) {
                    if ((currentLine = input.readLine()) != null) {
                        System.out.println(currentLine);
                        continue;
                    }

                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
                input.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("File not found");
            }
        } else System.out.println("Missing parameters");
    }
}
