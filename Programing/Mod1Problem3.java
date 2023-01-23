/*
Sam 1/15/22 1:52 CST

Deals with the GPS problem.

Car Methods:

   void Car() #Makes new Car object. Its the constructor.
   
   double CalcDistanceFromStart() #Calculates the distance from the start of the position to the current position using sqrt(x-x^2 + y-y^2) formula.
   
Vector2 Methods:

   void Vector2(<int>,<int>) #Makes a new vector2 object. Its the constructor.
   void Apply(<Vector2>) #Java does not support operator overloading, so I had to use a custom method. Applies vector to another vector. 1-1 or 1+1 ect.

Other Methods:
   Hashtable InitHash() # Allows me to create a hashtable so I dont have to worry about conditonal statments.
   Vector2 Get_Hash_Key() # Returns the vector2 direction from the key.
*/

import java.util.*;
import java.lang.Math;

class Vector2{

   public double X = 0;
   public double Y = 0;
   
   
   public Vector2(double X, double Y){
      this.X = X;
      this.Y = Y;
   }
   
   public void Apply(Vector2 OtherVector){
      this.X += OtherVector.X;
      this.Y += OtherVector.Y;
   }
}

class Car{

   Vector2 Position;
   Vector2 Start = new Vector2(0,0);

   public Car()
   {
      Position = new Vector2(0,0);
   }
   
   public double CalcDistanceFromStart(){ // I assume you ment Distance as in Vector Mathmatics. 
   
      double X1 = this.Position.X;
      double Y1 = this.Position.Y;
      
      double X2 = this.Start.X;
      double Y2 = this.Start.Y;
      
      double S1 = Math.pow(X1-X2, 2);
      double S2 = Math.pow(Y1-Y2, 2);
      
      return Math.sqrt(S1+S2);
   }
}



class Broken_GPS {

   static int DRIVE_TIME = 60; // In Min
   static int DRIVE_INTERVAL = 5; 
   static double IntervalDistance = DRIVE_TIME / DRIVE_INTERVAL; // How many miles we drove in DRIVE_INTERVAL min.
   
   static List<String> Directions = Arrays.asList("North", "South", "East", "West");
   
   private static Hashtable InitHash(){ // looks cleaner, init the Hash Table so I dont need to do a conditional/make new vector each time.
   
      Hashtable<String, Vector2> My_Dict = new Hashtable<String, Vector2>(); // cant use structs in Java, Hash Tables were the next best thing.
      
      Vector2 Up = new Vector2(0, IntervalDistance);
      Vector2 Down = new Vector2(0, -IntervalDistance);
      Vector2 Left = new Vector2(-IntervalDistance, 0);
      Vector2 Right = new Vector2(IntervalDistance, 0);
      
      My_Dict.put("North", Up);
      My_Dict.put("South", Down);
      My_Dict.put("East", Left);
      My_Dict.put("West", Right);
      
      return My_Dict;
   }
   
   static Hashtable My_Dict = InitHash();
   
   private static Vector2 Get_Hash_Key(){
   
      Collections.shuffle(Directions); // Shuffle the table, strings dont always work with Randomizer.
      String DirectionChoice = Directions.get(0);
      return (Vector2)My_Dict.get(DirectionChoice);

   }
   
   public static void main(String[] args) {
       
      Car New_Car = new Car(); // Car object with Vector2 as Position.
      
      for (int i = 0; i <= DRIVE_TIME; i += DRIVE_INTERVAL){
         
        Vector2 Direction = Get_Hash_Key();
        New_Car.Position.Apply(Direction);
   
      }
      
     //  System.out.println(New_Car.Position.X); 
//       System.out.println(New_Car.Position.Y); 
      
      System.out.println(New_Car.CalcDistanceFromStart());

   }
}