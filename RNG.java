import java.util.Scanner;
import java.util.Random;

/**
 * Simple Random Number Generator Program, prompts the user for a number of integers to be
 * generated, a number of times to generate those numbers, as well as a max and min value.
 * @author Jake Smithson
 */
public class RNG {

    /**
     * Runs indefinitely until the user enters Q when prompted, generates and prints the random
     * numbers for the specified number of times and within the specified range.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        String cont = "";
        while(true) {
            System.out.println();
            Scanner in = new Scanner(System.in);
            Random r = new Random();
            int n = 0;
            int t = 0;
            int max = 0;
            int min = 0;

            System.out.print("How many numbers do you want? (Q to quit): ");
            while(!in.hasNextInt()) {
                if(in.nextLine().equalsIgnoreCase("Q")) {
                    System.out.println();
                    System.exit(1);
                }
                if(in.hasNextInt()) {
                    n = in.nextInt();
                    if(n <= 0) {
                        System.out.print("Please enter an integer (>1): ");
                        in.next();
                    }
                }
                else {
                    System.out.print("Please enter an integer (>1): ");
                    in.next();
                }
            }
            in.nextLine();

            System.out.print("How many runs? (>1): ");
            while(!in.hasNextInt()) {
                if(in.hasNextInt()) {
                    t = in.nextInt();
                }
                else {
                    System.out.print("Please enter an integer (>1): ");
                    in.next();
                }
            }
            in.nextLine();

            System.out.print("Max?: ");
            while(!in.hasNextInt()) {
                if(in.hasNextInt()) {
                    max = in.nextInt();
                }
                else {
                    System.out.print("Please enter an integer: ");
                    in.next();
                }
            }
            in.nextLine();

            System.out.print("Min?: ");
            while(!in.hasNextInt()) {
                if(in.hasNextInt()) {
                    min = in.nextInt();
                }
                else {
                    System.out.print("Please enter an integer: ");
                    in.next();
                }
            }
            in.nextLine();

            System.out.println();
            for(int i = 0; i < t; i++) {
                printNumbers(r, n, max, min);
            }
            System.out.println();
        }
    }

    /**
     * Generates n number of random integers between max and min using Random object r.
     * @param r Random object used for generating random integers
     * @param n the number of integers to be generated
     * @param max the maximum value of the integers to be generated
     * @param min the minimum value of the integers to be generated
     */
    public static void printNumbers(Random r, int n, int max, int min) {
        for(int i = 0; i < n; i++) {
            System.out.printf("%5d",r.nextInt(max - min + 1) + min);
            if(i < n) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

}