public class Wall {

    private double wallHeight;
    private double wallWidth;

    public double surfaceArea() {
        double wallArea = this.wallHeight * this.wallWidth;
        return wallArea;
    }

    public void setWallHeight(double wallHeight) {
        this.wallHeight = wallHeight;
    }

    public void setWallWidth(double wallWidth) {
        this.wallWidth = wallWidth;
    }
}
