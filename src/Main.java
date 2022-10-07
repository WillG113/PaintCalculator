import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    // Calculations assumes walls are completely rectangular/square
    // It is assumed that each wall will be the same colour
    // Walls, windows, ceiling etc., are ignored in this instance

    /* - NON SCANNER
    //Walls Calc.
        double wallHeight = 240.0; //cm
        double wallWidth = 350.0; //cm
        int amountWalls = 4;

        double wallArea = wallHeight * wallWidth;
        double areaCoverage = wallArea * amountWalls;

    //Paint Calc.
        int paintLayers = 3;
        int canCoverage = 371612; //Apparent coverage of a gallon paint can in cm
        double pricePaintCans = 50.0;

        double totalCoverage = areaCoverage * paintLayers;
        double noPaintCans = Math.round(totalCoverage / canCoverage);
        double paintCost = noPaintCans * pricePaintCans;

    //Labor Calc.
        double hoursRequired = 12.0;
        double hourlyRate = 15.0;

        double laborCost = hoursRequired * hourlyRate;

    //Output
        System.out.println("The cost of paint will be: £" + String.format("%.2f", paintCost));
        System.out.println("The cost of labor will be: £" + String.format("%.2f", laborCost));
        System.out.println("Total cost of project: £" + String.format("%.2f", (paintCost + laborCost)));
    */

        Scanner input = new Scanner(System.in);

    //Walls Calc.
        System.out.println("How many walls need to be painted?");
        int amountWalls = input.nextInt();
        double totalArea = 0;

        for(int i = 1; i != amountWalls; i++) {
            System.out.println("What is the height of wall " + i + "?");
            double wallHeight = input.nextDouble();

            System.out.println("What is the width of wall " + i + "?");
            double wallWidth = input.nextDouble();

            double wallArea = wallHeight * wallWidth;

            System.out.println("Wall " + i + " has a surface area of " + wallArea);
            totalArea = totalArea + wallArea;
        }

    //Paint Calc.
        System.out.println("How many layers of paint are you applying?");
        int paintLayers = input.nextInt();

        int canCoverage = 371612; //Apparent coverage of a gallon paint can in cm
        double pricePaintCans = 57.33;

        double totalCoverage = totalArea * paintLayers;
        double noPaintCans = Math.ceil(totalCoverage / canCoverage);
        double paintCost = noPaintCans * pricePaintCans;

    //Labor Calc.
        System.out.println("How many hours of work will the project require?");
        double hoursRequired = input.nextDouble();

        System.out.println("What is your hourly rate? (£)");
        double hourlyRate = input.nextDouble();

        double laborCost = hoursRequired * hourlyRate;

    //Output
        System.out.println("The cost of paint will be - £" + String.format("%.2f", paintCost));
        System.out.println("The cost of labor will be - £" + String.format("%.2f", laborCost));
        System.out.println("Total cost of project - £" + String.format("%.2f", (paintCost + laborCost)));
    }
}