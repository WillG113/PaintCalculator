import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Calculations assumes walls are completely rectangular/square
        // It is assumed that each wall will be the same colour
        // Walls, windows, ceiling etc., are ignored in this instance

        double totalArea = wallsCalc();

        double[] paintValues = paintCalc(totalArea);

       double[] laborValues = laborCalc();

        output(paintValues, laborValues);

    }

    public static double wallsCalc() {

        Scanner input = new Scanner(System.in);

        System.out.println("How many walls need to be painted?");
        int amountWalls = input.nextInt();

        boolean sameHeight = false;
        double allHeight = -1.0;

        System.out.println("Are all of the walls the same height? Y/N");
        input.nextLine(); //Clears the scanner line

        while(allHeight < 0.0) {
            switch (input.nextLine().toUpperCase()) {
                case "Y" -> {
                    sameHeight = true;
                    System.out.println("What are the height of all the walls?");
                    allHeight = input.nextDouble();
                }
                case "N" -> {
                    sameHeight = false;
                    allHeight = 0.0;
                }
                default -> System.out.println("Please enter a valid value");
            }
        }

        double totalArea = 0;

        for(int i = 1; i < amountWalls + 1; i++) {

            double wallHeight;

            if(!sameHeight) {
                System.out.println("What is the height of wall " + i + "?");
                wallHeight = input.nextDouble();
            } else {
                wallHeight = allHeight;
            }

            System.out.println("What is the width of wall " + i + "?");
            double wallWidth = input.nextDouble();

            double wallArea = wallHeight * wallWidth;

            System.out.println("Wall " + i + " has a surface area of " + wallArea);
            totalArea += wallArea;
        }

        return totalArea;
    }

    public static double[] paintCalc(double totalArea) {

        Scanner input = new Scanner(System.in);

        System.out.println("How many layers of paint are you applying?");
        int paintLayers = input.nextInt();

        int canCoverage = 371612; //Apparent coverage of a gallon paint can in cm
        double pricePaintCans = 0.0;

        System.out.println("What quality of paint will be used?");
        System.out.println("Enter 1 for Cheap");
        System.out.println("Enter 2 for Standard");
        System.out.println("Enter 3 for Expensive");
        input.nextLine();

        while(pricePaintCans == 0.0) {
            pricePaintCans = switch (input.nextInt()) {
                case 1 -> 27.54;
                case 2 -> 65.54;
                case 3 -> 98.54;
                default -> 0.0;
            };

            if(pricePaintCans == 0.0) {
                System.out.println("Please enter a valid value");
            }
        }

        double totalCoverage = totalArea * paintLayers;
        double noPaintCans = Math.ceil(totalCoverage / canCoverage);
        double paintCost = noPaintCans * pricePaintCans;

        return new double[] {noPaintCans, pricePaintCans, paintCost};
    }

    public static double[] laborCalc() {

        Scanner input = new Scanner(System.in);

        System.out.println("How many hours of work will the project require?");
        double hoursRequired = input.nextDouble();

        System.out.println("What is your hourly rate? (£)");
        double hourlyRate = input.nextDouble();

        double laborCost = hoursRequired * hourlyRate;

        return new double[] {hoursRequired, hourlyRate, laborCost};
    }

    public static void output(double[] paintValues, double[] laborValues) {
        //Output

        System.out.println();
        System.out.println("--- PAINT ---");

        System.out.println("Number of paint cans required - " + paintValues[0]);
        System.out.println("Price per paint can - £" + paintValues[1]);
        System.out.println("Total cost of paint - £" + String.format("%.2f", (paintValues[2])));

        System.out.println();
        System.out.println("--- LABOR ---");

        System.out.println("Number of hours to work - " + laborValues[0]);
        System.out.println("Price per hour - £" + laborValues[1]);
        System.out.println("Total cost of labor - £" + String.format("%.2f", (laborValues[2])));

        System.out.println();
        System.out.println("--- TOTAL ---");

        System.out.println("Total cost of project - £" + String.format("%.2f", (paintValues[2] + laborValues[2])));
    }
}