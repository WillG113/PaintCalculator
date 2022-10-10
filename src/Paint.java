public class Paint {

   private double paintPrice;
   private int paintLayers;
   private double noPaintCans;

   public void setPaintPrice(double paintPrice){
       this.paintPrice = paintPrice;
   }

   public void setPaintLayers(int paintLayers){
       this.paintLayers = paintLayers;
   }

   public double getPaintPrice(){
       return this.paintPrice;
   }

   public double getNoPaintCans(){
       return this.noPaintCans;
   }

    public double noPaintCans(double areaToPaint) {
        double paintCoverage = 371612;
       areaToPaint *= this.paintLayers;
       this.noPaintCans = Math.ceil(areaToPaint / paintCoverage);
       return this.noPaintCans;
    }

    public double totalPaintCost() {
        return this.noPaintCans * paintPrice;
    }

}
