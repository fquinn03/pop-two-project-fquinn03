import fraction.Fraction;
import fraction.FractionImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter fraction 1: ");
        String fraction1 = sc.next();

        Fraction fractionA = new FractionImpl(fraction1);

        System.out.println("Enter fraction 2: ");
        String fraction2 = sc.next();

        Fraction fractionB = new FractionImpl(fraction2);

        System.out.println();

        Fraction result1 = fractionA.add(fractionB);
        System.out.println("The result of " + fractionA.toString() + " + " + fractionB.toString() + " is " + result1.toString());


        Fraction result2 = fractionA.subtract(fractionB);
        System.out.println("The result of " + fractionA.toString() + " - " + fractionB.toString() + " is " + result2.toString());


        Fraction result3 = fractionA.multiply(fractionB);
        System.out.println("The result of " + fractionA.toString() + " * " + fractionB.toString() + " is " + result3.toString());


        Fraction result4 = fractionA.divide(fractionB);
        System.out.println("The result of " + fractionA.toString() + " / " + fractionB.toString() + " is " + result4.toString());

    }
}