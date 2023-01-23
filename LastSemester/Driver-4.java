class BakeryStand{
   
   private int StandID;
   private int CupcakesSold;
   public static int TotalCupcakes;
   
   public BakeryStand(int StandID, int CupcakesSold){
      this.StandID = StandID;
      this.CupcakesSold = CupcakesSold;
      BakeryStand.TotalCupcakes += CupcakesSold;
   }
   
   
   public void SellCupcake(){
      this.CupcakesSold += 1;
      BakeryStand.TotalCupcakes += 1;
   }
   
   public int GetTotalCupcakes(){
      return this.CupcakesSold;
   }
   
   public static int GetTotalStandCupcakesSold(){
      return BakeryStand.TotalCupcakes;
   }
   
   @Override
   public String toString(){
      return String.format("Bakery Stand #%s has sold %s cupcakes. Collectivly all stands have sold %s cupcakes!", this.StandID, this.GetTotalCupcakes(), BakeryStand.GetTotalStandCupcakesSold());
   }

}


public class Driver{
   public static void main(String[] args)
   {
      BakeryStand[] StandsList = {new BakeryStand(1, 0), new BakeryStand(2, 0), new BakeryStand(3, 0)};
      
      for(int i = 0; i < StandsList.length; i++){
         StandsList[i].SellCupcake();
         StandsList[i].SellCupcake();
         StandsList[i].SellCupcake();
      }
      
       for(int i = 0; i < StandsList.length; i++){
         System.out.println(StandsList[i]);
      }

      
   }
}