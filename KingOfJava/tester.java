package KingOfJava;

import java.awt.print.Printable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class tester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputNum = 0;
        System.out.println("please enter a number 1 - 3");
        try {
            inputNum = scan.nextInt();
        }
        catch (InputMismatchException e) {
            scan.nextLine();
        }
        while (1 > 0/* Conditional Goes Here */) {
            //print statement
            try {
                inputNum = scan.nextInt();
            }
            catch (InputMismatchException e) {
                scan.nextLine();
            }
        }
    }
}