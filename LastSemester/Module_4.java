import java.util.*;

class Problem_1{
   
   
   public Problem_1(){}
   
   public Character FindScore(int Score){ // Switch statment is a faster alternative
      if(Score >= 90){
         return 'A';
      }
      else if(Score >= 80 && Score < 90){
         return 'B';
      }
      else if(Score >= 70 && Score < 80){
         return 'C';   
      }
      else if(Score >= 60 && Score < 70){
         return 'D';
      }
      else{
         return 'F';
      }
   }
}

class Package{

   private float Cost;
   private float Weight;

   public Package(float Weight){
   
      float Modif = 0.0f;
      
      if(5 <  Weight && Weight <= 10){
         Modif = 1.00f;
      }
      else if(10 < Weight && Weight <= 20){
         Modif = 0.90f;
      }
      else{
         Modif = 0.80f;
      }
      
      System.out.println(Modif);
      this.Cost = Weight * Modif;
      System.out.println(String.format("Weight: %s \nCost: %s", this.Weight, this.Cost));
   }
   
   public float getCost(){
      return this.Cost;
   }
   
   public float getWeight(){
      return this.Weight;
   }
   
   @Override
   public String toString(){
      return String.format("Weight: %s \nCost: %s", this.Weight, this.Cost);
   }
   
}


class Problem_2{
   
   private ArrayList<Package> Packages = new ArrayList();
   
   public Problem_2(){}
   
   public void NewPackage(float Weight){
      Package PackageToAdd = new Package(Weight);
      Packages.add(PackageToAdd);
   }
   
   public void PrintPackages(){
      for(int i = 0; i < Packages.size(); i++){
         System.out.println(Packages.get(i));
      }
   }

}


public class Module_4{
   
   public static void main(String[] args){
   
      Problem_1 Sol_1 = new Problem_1();
      System.out.println(Sol_1.FindScore(5));
      
      Problem_2 Sol_2 = new Problem_2();
      Sol_2.NewPackage(15);
   }

}