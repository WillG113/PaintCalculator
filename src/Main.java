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
        boolean sameHeight = false;
        double allHeight = 0.0;
        boolean decisionMade = false;

        System.out.println("How many walls need to be painted?");
        int amountWalls = input.nextInt();

        System.out.println("Are all of the walls the same height? Y/N");
        input.nextLine(); //Clears the scanner line

        while(!decisionMade) {
            switch (input.nextLine().toUpperCase()) {
                case "Y" -> {
                    decisionMade = true;
                    sameHeight = true;
                    System.out.println("What are the height of all the walls?");
                    allHeight = input.nextDouble();
                }
                case "N" -> {
                    decisionMade = true;
                    allHeight = 0.0;
                }
                default -> System.out.println("Please enter a valid value");
            }
        }

        double totalArea = 0;

        for(int i = 1; i < amountWalls + 1; i++) {

            Wall wallObject = new Wall();

            if(!sameHeight) {
                System.out.println("What is the height of wall " + i + "?");
                wallObject.setWallHeight(input.nextDouble());
            } else {
                wallObject.setWallHeight(allHeight);
            }

            System.out.println("What is the width of wall " + i + "?");
            wallObject.setWallWidth(input.nextDouble());
// 8.5 14.6
            double wallArea = wallObject.surfaceArea();
            totalArea += wallArea;

            System.out.println("Wall " + i + " has a surface area of " + wallArea);
        }

        totalArea -= obstructionsCalc();
        return totalArea;
    }

    public static double[] paintCalc(double totalArea) {

        Paint paint = new Paint();
        Scanner input = new Scanner(System.in);

        System.out.println("How many layers of paint are you applying?");
        paint.setPaintLayers(input.nextInt());

        boolean decisionMade = false;

        System.out.println("What quality of paint will be used?");
        System.out.println("Enter 1 for Cheap Paint");
        System.out.println("Enter 2 for Standard Paint");
        System.out.println("Enter 3 for Expensive Paint");
        input.nextLine();

        while(!decisionMade) {
            switch (input.nextInt()) {
                case 1 -> {
                    paint.setPaintPrice(23.65);
                    decisionMade = true;
                }
                case 2 -> {
                    paint.setPaintPrice(46.66);
                    decisionMade = true;
                }
                case 3 -> {
                    paint.setPaintPrice(83.54);
                    decisionMade = true;
                }
            }

            if(!decisionMade) {
                System.out.println("Please enter a valid value");
            }
        }

        paint.noPaintCans(totalArea);
        double paintCost = paint.totalPaintCost();

        return new double[] {paint.getNoPaintCans(), paint.getPaintPrice(), paintCost};
    }

    public static double[] laborCalc() {

        Scanner input = new Scanner(System.in);

        System.out.println("Approximately how many hours of work will the project require?");
        double hoursRequired = input.nextDouble();

        System.out.println("What is your hourly rate? (£)");
        double hourlyRate = input.nextDouble();

        double laborCost = hoursRequired * hourlyRate;

        return new double[] {hoursRequired, hourlyRate, laborCost};
    }

    public static double obstructionsCalc() {
        Scanner input = new Scanner(System.in);
        int inputValue;
        double obstructionArea = 0;

        //WINDOWS -- For now we are assuming all the windows are the average size
        System.out.println("How many windows are in the room?");
        inputValue = input.nextInt();
        if(inputValue > 0) {
            Window window = new Window();
            obstructionArea += window.totalWindowArea(inputValue);
        }

        //DOORS
        System.out.println("How many doors are in the room?");
        inputValue = input.nextInt();
        if(inputValue > 0) {
            Door door = new Door();
            obstructionArea -= door.totalDoorArea(inputValue);
        }

        //OTHER OBSTACLES -- Definitely needs improvement, for now we assume that every lightswitch will be the sme size etc.
        System.out.println("How many other types of obstructions are there? e.g light switch, radiator, etc.");
        int uniqueObstrucations = input.nextInt();
        input.nextLine();

        for (int i = 0;  i < uniqueObstrucations; i++) {
            Obstacle obstacle = new Obstacle();

            System.out.println("What type of obstacle is obstacle " + (i + 1) + "? e.g Lightswitch");
            obstacle.setObstacleName(input.nextLine());

            System.out.println("What is the height of the " + obstacle.getObstacleName() + "?");
            obstacle.setObstacleHeight(input.nextDouble());

            System.out.println("What is the width of the " + obstacle.getObstacleName() + "?");
            obstacle.setObstacleWidth(input.nextDouble());

            obstacle.obstacleArea();

            System.out.println("How many " + obstacle.getObstacleName() + " are there in the room?");
            obstacle.setAmount(input.nextInt());
z
            input.nextLine();

            obstructionArea += obstacle.totalObstacleArea();
        }
        return obstructionArea;
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
        System.out.println("Price per hour - £" + String.format("%.2f", (laborValues[1])));
        System.out.println("Total cost of labor - £" + String.format("%.2f", (laborValues[2])));

        System.out.println();
        System.out.println("--- TOTAL ---");

        System.out.println("Total cost of project - £" + String.format("%.2f", (paintValues[2] + laborValues[2])));
    }
}