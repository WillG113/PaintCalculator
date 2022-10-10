public class Door {

    private final double doorHeight = 197;
    private final double doorWidth = 80;
    double doorArea = doorWidth * doorHeight;

    public double totalDoorArea(int totalDoors) {
        return totalDoors * doorArea;
    }

}
