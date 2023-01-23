/*
Sam 1/25/22 9:01 am CST

Solves Problem 1; Girl Scout Cookies.


I create an object that handles all the core methods. In that class I experiment with private and public access modifiers as well as learn how to format tables correctly.
To solve I simply create an object and set the number of scouts that the object will hold. I then input the data based off the number of scouts given. Finally, I calculate the results
depending on the ranges that you give. 
This code is fully scalable to any size. You can do this with any number of ranges and scouts.
*/

import java.util.*;
import java.io.*;


class GirlScoutMain{
   
   
   public int ScoutNumber;
   
   private int[] GirlScoutsData;
   private int[][] RANGES = {{0,10}, {11,20}, {21,30}, {31, 40}, {41, Integer.MAX_VALUE}};
   private Scanner SYSTEM_SCANNER = new Scanner(System.in);
   
   public GirlScoutMain(int TotalScouts){
      
      SetScoutNumber(TotalScouts);
      GirlScoutsData = new int[this.ScoutNumber];

   }
   
   private void SetScoutNumber(int Value){
      this.ScoutNumber = Value;
   }
   
   public void DisplayResults(){
   
      int[] Results = CalculateResults();
      PrintWriter Printer = new PrintWriter(System.out); // Used this to format.
      
      Printer.println("Total Boxes\t\tNumber of Girl Scouts");
      
     
      for(int i = 0; i < Results.length; i++){
         if(RANGES[i][1] > 41){
            Printer.println(String.format("%s or more\t\t         %s", RANGES[i][0],  Results[i]));
         }
         else{
            Printer.println(String.format("%s or %s\t\t\t         %s",  RANGES[i][0], RANGES[i][1],  Results[i]));
         }
      }
      
      Printer.close();
   }
   
   private int[] CalculateResults(){
      
      int MaxIndex = RANGES.length;
      int CurrentIndex = 0;
      int[] Results = new int[MaxIndex];
      
      for(int i = 0; i < GirlScoutsData.length; i++){      
      
         while(CurrentIndex < MaxIndex){
            if(GirlScoutsData[i] >= RANGES[CurrentIndex][0] && GirlScoutsData[i] <= RANGES[CurrentIndex][1]){
               Results[CurrentIndex]++;
            }
            
            CurrentIndex++;
         }
         
         CurrentIndex = 0;
      
      }
      return Results;
   }
   
   public void TakeInput(){
 
      int CurrentIndex = 0;
            
      while(CurrentIndex <= this.ScoutNumber - 1){
         System.out.println(String.format("How many cookies did scout %s sell?", CurrentIndex + 1));
         GirlScoutsData[CurrentIndex] = SYSTEM_SCANNER.nextInt();
         CurrentIndex++;
      }
   
   }

}


class Main{

   private static Scanner SYSTEM_SCANNER = new Scanner(System.in);
   
   public static void main(String[] args){
      
      System.out.println("Please enter how many scouts will be accounted for.");
      GirlScoutMain ScoutObject = new GirlScoutMain(SYSTEM_SCANNER.nextInt());
      ScoutObject.TakeInput();
      ScoutObject.DisplayResults();
      
   }

}