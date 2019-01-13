import fraction.Fraction;
import fraction.FractionImpl;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    while(true) {
            String operation = "";
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Enter fraction 1: ");
            String fraction1 = sc.nextLine();

            Fraction fractionA = new FractionImpl(fraction1);

            System.out.println("Enter fraction 2: ");
            String fraction2 = sc.nextLine();

            Fraction fractionB = new FractionImpl(fraction2);

            System.out.println();

            System.out.println("Please enter operation. (+, -, *, /, compare)");
            operation = sc.nextLine();
            if(operation != "") {
                char op = operation.toLowerCase().charAt(0);

                switch (op) {
                    case ('+'):
                        Fraction result1 = fractionA.add(fractionB);
                        System.out.println("The result of " + fractionA.toString() + " + " + fractionB.toString() + " is " + result1.toString());
                        break;
                    case ('-'):
                        Fraction result2 = fractionA.subtract(fractionB);
                        System.out.println("The result of " + fractionA.toString() + " - " + fractionB.toString() + " is " + result2.toString());
                        break;
                    case ('*'):
                        Fraction result3 = fractionA.multiply(fractionB);
                        System.out.println("The result of " + fractionA.toString() + " * " + fractionB.toString() + " is " + result3.toString());
                        break;
                    case ('/'):
                        Fraction result4 = fractionA.divide(fractionB);
                        System.out.println("The result of " + fractionA.toString() + " / " + fractionB.toString() + " is " + result4.toString());
                        break;
                    case ('c'):
                        int comparision = fractionA.compareTo(fractionB);

                            if (comparision == 1) {
                                System.out.println(fractionA.toString() + " is greater than " + fractionB.toString());
                                break;
                            }
                            if (comparision == 0) {
                                System.out.println(fractionA.toString() + " is equal to " + fractionB.toString());
                                break;
                            }
                            if (comparision == -1) {
                                System.out.println(fractionA.toString() + " is less than " + fractionB.toString());
                                break;
                            }
                        break;

                    default:
                        System.out.println("You must enter (+, -, *, /)");
                }
            }
            System.out.println();
            System.out.println("Enter 'q' to quit, or any other character to enter another set of fractions. ");
            String quit = sc.nextLine();
            char quit1 = quit.charAt(0);
            if(quit1 == 'q'){
                System.exit(0);
            }

        }
    }
}