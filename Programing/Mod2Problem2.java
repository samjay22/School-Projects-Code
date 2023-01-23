/*
Sam 1/25/22 8:50 am CST

Solves problem 2; the diving judge problem.


I used a scanner object that each class inherits. I did this so I did not need to assign a scanner for each object. 

To solve I created a Score object, Judge object, and a main object that deals with everything. Each class has its on functions
Score deals with the score aspect. Judge deal with the Judge aspects, main connects to all of the other classes.

Everything works according to the problem given. As of writing this the code works 100%.
*/


import java.util.*;
import java.lang.*;

class MyScanner{
   public final static Scanner SYSTEM_SCANNER = new Scanner(System.in);
}

class Score extends MyScanner{
   
   public float ScoreValue;
   
   public Score(float Value){
   
      SetScore(Value);
   }
   
   private void SetScore(float Value){
      this.ScoreValue = Value;
   }
   
   public void ApplyMultiplier(float Multiplier){
      this.ScoreValue *= Multiplier;
   }
   
   public Score CalculateScore(){
      this.ScoreValue *= 0.6f;
      return this;
   }

}



class Judge extends MyScanner{
   
   public Score JudgeScore;
   private float DifficultyDegree;
   
   public Judge(float Degree){
      SetDegree(Degree);
      SetScore();
   }
   
   private void SetDegree(float Degree){
      System.out.println(Degree);
      this.DifficultyDegree = Degree;
   }
   
   private Score SetScore(){
   
      float Value;
      
      System.out.println("Please enter the judge's score between 0 and 10.");
      Value = SYSTEM_SCANNER.nextFloat();
      
      if(Value >= 0 && Value <= 10){
         Score ScoreObject = new Score(Value);
         ScoreObject.ApplyMultiplier(this.DifficultyDegree);
         this.JudgeScore = ScoreObject;
         return ScoreObject;
      }
      else{
         return SetScore();
      }
   }
   
   public Score GetJudgeScore(){
      return this.JudgeScore;
   }
   
   public Score GetFinalScore(){
      return this.JudgeScore.CalculateScore();
   }

}




class Manager extends MyScanner{
   
   public static Judge InputValidScore(float Degree){

      Judge NewJudge = new Judge(Degree);
      
      return NewJudge;
   } 
   
   public static Judge[] InputAllScores(){
   
      Judge[] Judges = new Judge[7];
      
        return Judges;
   }
   
   public static float InputValidDegreeOfDifficulty(){
   
      float Multi;
      
      System.out.println("Plase input a valid degree of difficulty from 1.2 to 3.8");
      Multi = SYSTEM_SCANNER.nextFloat();
      
      if(Multi >= 1.2 && Multi <= 3.8){
         return Multi;
      }
      else{
         return InputValidDegreeOfDifficulty();
      }
      
   }
   
   public static float CalculateScore(Judge[] Judges){
   
      float TotalScore = 0.0f;
      
      for(int i = 0; i < Judges.length; i++){
         TotalScore += Judges[i].GetFinalScore().ScoreValue;
      }
      
      return TotalScore;
   }
   
   private static float Round(float Number){
      return Math.round(Number * 100.00f) / 100.00f;
   }
   
   public static void main(String[] args){
   
      float Degree = InputValidDegreeOfDifficulty();
      Judge[] Judges = InputAllScores();

      for(int i = 0; i < Judges.length; i++){
         System.out.println(String.format("Current Judge: %s", i + 1));
         Judges[i] = InputValidScore(Degree); 
      }
      
      float Score = CalculateScore(Judges);
      
      for(int i = 0; i < Judges.length; i++){
         System.out.println(String.format("Judge %s Score is: %s",i + 1, Round(Judges[i].JudgeScore.ScoreValue)));
      }
      
      System.out.println(String.format("Difficulty Degree: %s", Round(Degree)));
      System.out.println(String.format("Total Score: %s", Round(Score)));
   }

}