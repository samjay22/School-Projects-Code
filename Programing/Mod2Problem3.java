/* 
Sam 1/26/22 12 PM CST


Solves Problem 3, the tempature problem.


I created a custom StructClass to hold code that would be used more than once in both functions. 

To solve I created a year class that inherits from the struct as well as a main class that inherits from mystruct. 

Everything works.

*/

import java.util.*;
import java.text.DateFormatSymbols;

class MyStruct{
   Scanner SYSTEM_SCANNER = new Scanner(System.in);
   
   public static String GetMonth(int Month) {
      return new DateFormatSymbols().getMonths()[Month];
   }
}

class Year extends MyStruct{
   
   public Year(){}
   
   public void InputTempForMonth(int[][] Tempatures, int Month){
      System.out.println(String.format("Input Low for %s", GetMonth(Month)));
      Tempatures[Month][0] = SYSTEM_SCANNER.nextInt();
      System.out.println(String.format("Input High for %s", GetMonth(Month)));
      Tempatures[Month][1] = SYSTEM_SCANNER.nextInt();
   }
   
   public int[][] InputTempForYear(){
   
      int[][] Tempatures = new int[12][2];
      
      for(int i = 0; i < 12; i++){
        InputTempForMonth(Tempatures, i);
      }
      
      return Tempatures;
   }
   
   private float GetAverage(int[][] Tempatures, int Index){
   
      float Average = 0.0f;
      
      for(int i = 0; i < Tempatures.length; i++){
         Average += (float)Tempatures[i][Index];
      }
      
      return Average / (float)(Tempatures.length);
   }
   
    public float CalculateAverageLow(int[][] Tempatures){
      return GetAverage(Tempatures, 0);
   }

   
   public float CalculateAverageHigh(int[][] Tempatures){
      return GetAverage(Tempatures, 1);
   }
   
   public int[] FindLowestTemp(int[][] Tempatures){
   
      int Lowest = Integer.MAX_VALUE;
      int Month = 0;
      
      for(int i = 0; i < Tempatures.length; i++){
         if(Tempatures[i][0] < Lowest){
            Lowest = Tempatures[i] [0];
            Month = i;
         }
      }
      int[] Array = new int[Month + 2];
      Array[Array.length - 1] = Lowest;
      return Array;
   }
   public int[] FindHighestTemp(int[][] Tempatures){
   
      int Highest = Integer.MIN_VALUE;
      int Month = 0;
      
      for(int i = 0; i < Tempatures.length; i++){
         if(Tempatures[i][1] > Highest){
            Highest = Tempatures[i][1];
            Month = i;
         }
      }
      
      int[] Array = new int[Month + 2];
      Array[Array.length - 1] = Highest;

      return Array;
   }

}

class Main extends MyStruct{


   public static void main(String[] ags){
      Year My_Year = new Year();
      int[][] MyTemps = My_Year.InputTempForYear();
      
      String AverageHigh = String.format("Average High: %s", My_Year.CalculateAverageHigh(MyTemps));
      String AverageLow = String.format("Average Low: %s", My_Year.CalculateAverageLow(MyTemps));
      
      int[] LowestData = My_Year.FindLowestTemp(MyTemps);
      int[] HigestData = My_Year.FindHighestTemp(MyTemps);
      
      String HighestTemp = String.format("Highest Temp: %s in Month: %s ", HigestData[HigestData.length - 1], GetMonth(HigestData.length - 2));
      String LowestTemp = String.format("Lowest Temp: %s in Month: %s ", LowestData[LowestData.length - 1], GetMonth(LowestData.length - 2));
      
      System.out.println(String.format(
      
      "\n %s \n %s \n %s \n %s \n",  AverageHigh, AverageLow, HighestTemp, LowestTemp
      
      ));
   }
   
   

}