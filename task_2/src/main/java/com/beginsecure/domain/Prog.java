package com.beginsecure.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prog {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("file.txt"));
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");

            int[] intNumbers = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                intNumbers[i] = Integer.parseInt(numbers[i]);
            }

            System.out.println("min: " + _min(intNumbers));
            System.out.println("max: " + _max(intNumbers));
            System.out.println("sum: " + _sum(intNumbers));
            System.out.println("mult: " + _mult(intNumbers));

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    public static int _min(int[] numbers) {
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public static int _max(int[] numbers) {
        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static int _sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static int _mult(int[] numbers) {
        int mult = 1;
        for (int number : numbers) {
            mult *= number;
        }
        return mult;
    }
}
