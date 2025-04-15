
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CalculatorApp {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Variable Introductions
        boolean keepRunning = true;

        Scanner scanner = new Scanner(System.in);

        while (keepRunning) {
            boolean correctChoice = false; //Makes sure the right calculator was selected
            // This loop is to confirm the correct calculator and initalize it.
            while (!correctChoice) {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("\nHello User! Which calculator Services are required?");
                System.out.println("\n(M)ortgage Calculator");
                System.out.println("(F)uture Value Calculator");
                System.out.println("(P)resent Value Calculator");
                System.out.println("(X) Exit Program");
                System.out.println("\nPlease Choose with corresponding character (M), (F), (P) or (X): ");


                String calcSelectString = scanner.nextLine().toUpperCase();
                char calcSelectChar = calcSelectString.charAt(0);
                try {
                    if (calcSelectChar == 'M') {
                        System.out.println("\n\n\nYou have chosen (M)ortgage Calculator!");
                        System.out.println("Was this correct? (Y) or (N)");

                        // Gathers and converts user input to char
                        String calcConfirmString = scanner.nextLine().toUpperCase();
                        char calcConfirmChar = calcConfirmString.charAt(0);
                        if (calcConfirmChar == 'Y') {
                            CalculatorApp.mortgageCalculator();// Runs Mortgage Calculator Function
                            correctChoice = true;
                        } else {
                            System.out.println("Please make another selection.");
                            continue;
                        } // Else End

                    } else if (calcSelectChar == 'F') {
                        System.out.println("\n\n\nYou have chosen (F)uture Value Calculator!");
                        System.out.println("Was this correct? (Y) or (N)");

                        // Gathers and converts user input to char
                        String calcConfirmString = scanner.nextLine().toUpperCase();
                        char calcConfirmChar = calcConfirmString.charAt(0);
                        if (calcConfirmChar == 'Y') {
                            CalculatorApp.futureValueCalculator();// Runs Mortgage Calculator Function
                            correctChoice = true;
                        } else {
                            System.out.println("Please make another selection.");
                            continue;
                        } // Else End
                    } else if (calcSelectChar == 'P') {
                        System.out.println("\n\n\nYou have chosen (P)resent Value Calculator!");
                        System.out.println("Was this correct? (Y) or (N)");

                        // Gathers and converts user input to char
                        String calcConfirmString = scanner.nextLine().toUpperCase();
                        char calcConfirmChar = calcConfirmString.charAt(0);
                        if (calcConfirmChar == 'Y') {
                            CalculatorApp.presentValueCalculator();// Runs Mortgage Calculator Function
                            correctChoice = true;
                        } else {
                            System.out.println("Please make another selection.");
                            continue;
                        } // Else End
                    } else if (calcSelectChar == 'X') {
                        correctChoice = true;
                        keepRunning = false;
                    } else {
                        System.out.println("-------------------------------------------");
                        System.out.println("Invalid input" + calcSelectChar);
                    }
                } catch (ArithmeticException e) {
                    System.out.println("---------------------------------");
                    System.out.println("\nInvalid input, numbers only.");
                    System.out.println("---------------------------------");
                    continue;
                } catch (NumberFormatException e) {
                    System.out.println("---------------------------------");
                    System.out.println("\nInvalid input, numbers only.");
                    System.out.println("---------------------------------");
                    continue;
                }

            } // Calc Init While Loop

            // Keep Running Calculator Program Input
            System.out.println("\nDo you need to perform another operation? (Y) / (N)");
            char userInput = scanner.nextLine().toUpperCase().charAt(0);
            if (userInput != 'Y') {
                keepRunning = false;
                System.out.println("Thank you for using my Calculator App");
            } else {
                continue;
            }
        }// KeepGoing Loop

    } // PSVM END

    // Method 1
    public static void mortgageCalculator() {
        // Variable Introductions
        Scanner scanner = new Scanner(System.in);
        double principal = 0;
        double annualInterest = 0;
        double yearsLoanTerm = 0;

        // Introduce System
        System.out.println("\nThank you for confirming: (M)ortgage Calculator");
        System.out.println("I will ask for information, one number at a time.");

        // Gather Principal
        while (principal <= 0) {

            System.out.println("\nWhat is your Principle (Total amount of the loan)?");
            System.out.println("Enter: ");

            try {
                principal = Double.parseDouble(scanner.nextLine());
                break;
            } catch (ArithmeticException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            }
        }
        //Gather Annual Interest Rate
        while (annualInterest <= 0) {

            System.out.println("\nWhat is your Annual Interest Rate (in % form) ");
            System.out.println("Enter: ");
            try {
                annualInterest = Double.parseDouble(scanner.nextLine());
            }  catch (ArithmeticException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            }
        }
        //Gather Loan Term In Years
        while (yearsLoanTerm <= 0) {

            System.out.println("\nHow many years are you paying off this loan for? Please enter whole number ex: 1, 2...");
            System.out.println("Enter: ");
            try {
                yearsLoanTerm = Double.parseDouble(scanner.nextLine());
            } catch (ArithmeticException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            }
        }
        //Variables Needed for Calc
        double numberMonthlyPayments = 12 * yearsLoanTerm;
        double interestRateMonthly = annualInterest / 12;

        //Abbreviated variables for ease of use
        double p = principal;
        double r = (annualInterest/100);
        double y = yearsLoanTerm;
        double i = r / 12;
        double n = numberMonthlyPayments;


//        M=P×(i*(1+i)^n / ((1+i)^n)-1)
        double monthlyPayments = p * ((i * (Math.pow((1 + i), n))) / ((Math.pow((1 + i), n)) - 1));

        // Creation of 'm' variable
        double m = monthlyPayments;

        //Result Variable
        BigDecimal totalInterest = new BigDecimal((m * n) - p);
        totalInterest = totalInterest.setScale(2, RoundingMode.HALF_UP);

        BigDecimal mp = new BigDecimal(monthlyPayments);
        mp = mp.setScale(2, RoundingMode.HALF_UP);

        System.out.println("\n Based on your information: ");
        System.out.println("Principal: $" + principal);
        System.out.println("Annual Interest rate: " + annualInterest + "%");
        System.out.println("Loan Term In Years: " + yearsLoanTerm);
        System.out.println("\nHere is your total Monthly Payment is: $" + mp);
        System.out.println("\nHere is your Total Interest to be Paid: $" + totalInterest);


    }
    // Method 2
    public static void futureValueCalculator () {
        // Variable Introductions
        Scanner scanner = new Scanner(System.in);
        double principal = 0;
        double annualInterest = 0;
        double yearsNumber = 0;

        // Introduce System
        System.out.println("\nThank you for confirming: (F)uture Value Calculator");
        System.out.println("I will ask for information, one number at a time.");

        // Gather Principal
        while (principal <= 0) {
            System.out.println("\nWhat is your Principal? (Initial Deposit Amount)?");
            System.out.println("Enter: ");
            try {
                principal = Double.parseDouble(scanner.nextLine());
                break;
            } catch (ArithmeticException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            }
        }
        //Gather Annual Interest Rate
        while (annualInterest <= 0) {
            System.out.println("\nWhat is your Annual Interest Rate (In % form) ");
            System.out.println("Enter: ");
            try {
                annualInterest = Double.parseDouble(scanner.nextLine());
                break;
            } catch (ArithmeticException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            }
        }
        //Gather Deposit Time In Years
        while (yearsNumber <=0) {
            System.out.println("\nHow many years ahead do you want to predict (enter whole number ex: 1, 2....)?");
            System.out.println("Enter: ");
            try {
                yearsNumber = Double.parseDouble(scanner.nextLine());
                break;
            } catch (ArithmeticException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            }
        }

        //Abbreviated Variables for Ease of Use
        double p = principal;
        double r = annualInterest / 100;
        double t = yearsNumber;
        double futureValue = p * (Math.pow(1 + (r / 365.25), (365.25 * t)));
        double totalInterest = futureValue - p;

        //Rounding Conversions
        BigDecimal fv = new BigDecimal(futureValue);
        fv = fv.setScale(2, RoundingMode.HALF_UP);

        BigDecimal ti = new BigDecimal(totalInterest);
        ti = ti.setScale(2, RoundingMode.HALF_UP);


        System.out.println("\n Based on your information: ");
        System.out.println("Principal/Inital Deposit: $" + principal);
        System.out.println("Annual Interest rate: " + annualInterest + "%");
        System.out.println("Deposit Time In Years: " + yearsNumber);

        System.out.println("\nHere is your estimated Future Value: $" + fv);
        System.out.println("\nHere is your Total Interest gained: $" + ti);
    }
    // Method 3
    public static void presentValueCalculator () {
        // n = number of periods (7 years = 12 * 7 = 84)
        // r = period interest rate (annual rate/# of periods per year)
        // p = payment each period
        // Present value = p * (Math.pow((1 - (1 + r)), (-1 * n)) / r)
        //Introduce Variables
        Scanner scanner = new Scanner(System.in);
        double paymentPerPeriod = 0;
        double annualInterest = 0;
        double yearsNumber = 0;

        // Introduce System
        System.out.println("\nThank you for confirming: (P)resent Value Calculator");
        System.out.println("I will ask for information, one number at a time.");

        // Gather Payments Each Period
        while (paymentPerPeriod <= 0) {
            System.out.println("\nHow much will you be paying per month? (Period)");
            System.out.println("Enter: ");
            try {
                paymentPerPeriod = Double.parseDouble(scanner.nextLine());
                break;
            } catch (ArithmeticException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            }
        }

        //Gather Annual Interest Rate
        while (annualInterest <= 0) {
            System.out.println("\nWhat is your Annual Interest Rate (In % form) ");
            System.out.println("Enter: ");
            try {
                annualInterest = Double.parseDouble(scanner.nextLine());
                break;
            } catch (ArithmeticException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            }
        }

        //Gather Deposit Time In Years
        while (yearsNumber <= 0){
            System.out.println("\nHow many years will you be paying?");
            System.out.println("Enter: ");
            try {
                yearsNumber = Double.parseDouble(scanner.nextLine());
            } catch (ArithmeticException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("---------------------------------");
                System.out.println("\nInvalid input, numbers only.");
                System.out.println("---------------------------------");
                continue;
            }
        }

        // Abbreviated Variables for Ease of Use
        double n = -1 * (12 * yearsNumber);
        double r = (annualInterest / 100) / 12;
        double p = paymentPerPeriod;
        double presentValue = p * (1 - Math.pow(1 + r, n)) / r;

        BigDecimal pv = new BigDecimal(presentValue);
        pv = pv.setScale(2, RoundingMode.HALF_UP);

        System.out.println("\nBased on your information: ");
        System.out.println("Payment per month: $" + paymentPerPeriod);
        System.out.println("Anual Interest Rate: " + annualInterest + "%");
        System.out.println("Years to be paid: " + yearsNumber);
        System.out.println("The Estimated Present Value is: $" + pv);
    }



} //CALC APP CLASS END
