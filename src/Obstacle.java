public class Obstacle {

    private String obstacleName;
     private double obstacleHeight;
    private double obstacleWidth;
    private double obstacleArea;
    private int amount;

    public void setObstacleName(String obstacleName){
        this.obstacleName = obstacleName;
    }

    public void setObstacleHeight(double obstacleHeight) {
        this.obstacleHeight = obstacleHeight;
    }

    public void setObstacleWidth(double obstacleWidth) {
        this.obstacleWidth = obstacleWidth;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public String getObstacleName(){
        return this.obstacleName;
    }

    public void obstacleArea() {
        this.obstacleArea = this.obstacleHeight * this.obstacleWidth;
    }

    public double totalObstacleArea() {
        return this.obstacleArea * this.amount;
    }

}
