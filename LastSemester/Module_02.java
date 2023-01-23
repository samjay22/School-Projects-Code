/*
Before I wrote this program I looked at what was asked. The first thing that came to mind was regarding problem 1 and how exactly I was going to store the information.
Because there are different types of actions I considered using enums, however, then I moved to a more hashmap based approach simply because it made my code less complex.
I simply created a hashmap to store the actions with the costs, then I thought about creating a class to simply hold the data from the current input and keep track. 
Then I considered taking advantage of the tostring method to output the total information thus solving the problem.

Problem 2 was a little less complex. I simply created an object to deal with the conversions using one method. Then I just printed the converted value in the console.
For the sake of time and simplicity I contained both problems under one driver class with the most best coding methods.

*/


import java.util.*;




class METS{
   
   private final HashMap<String, Double> METSValues = new HashMap<>();
   
   private double TotalMET;
   private double Weight;
   
   public METS(double Weight){ // not the fastest due to us adding values every instantiation. But it is still O(n) space and time.
   
      this.Weight = Weight;
      
      METSValues.put("Running", 10.0);
      METSValues.put("Basketball", 8.0);
      METSValues.put("Sleeping", 1.0);
      
   }
   
   public void AddMETValue(String Action, int Min){
      TotalMET += (0.0175 * METSValues.get(Action) * this.Weight) * Min;
   }
   
   @Override  
   public String toString(){
      return String.format("Total MET: %g", this.TotalMET);
   }
}

class TempConversion{
   
   public TempConversion(){}
   
   public void Celsius(double Fahrenheit){
      double Cels = ((Fahrenheit  - 32) * 5) / 9;
      System.out.println(String.format("Fahrenheit Temperature: %f \nCelsius Temperature: %f", Fahrenheit, Cels));
   }
   
}


public class Module_02{
   
   public static void main(String[] args){
      
      METS MetObject = new METS(150);
      MetObject.AddMETValue("Running", 30);
      MetObject.AddMETValue("Basketball", 30);
      MetObject.AddMETValue("Sleeping", 6 * 60);
      
      TempConversion TempObject = new TempConversion();
      TempObject.Celsius(87.6);
      
      System.out.println();
      System.out.println(MetObject);
      
   }
   
}
