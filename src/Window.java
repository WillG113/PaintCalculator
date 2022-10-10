public class Window {

    private final double windowHeight = 73.6;
    private final double windowWidth = 119.4;
    double windowArea = windowWidth * windowHeight;

    public double totalWindowArea(int totalWindows) {
        return totalWindows * windowArea;
    }

}
