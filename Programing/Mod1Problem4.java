/*

Sam 1/17/22 3:03 pm CST

Solves problem 4.

Methods:

   void Addition(<double>, <double>, <double>, <double>) # Adds and Adds it to the HashTable Answers.
   void Subtraction(<double>, <double>, <double>, <double>) # Subtracts and Adds it to the HashTable Answers.
   void Division(<double>, <double>, <double>, <double>) # Divides and Adds it to the HashTable Answers.
   void Multiplication(<double>, <double>, <double>, <double>) # Multiplies and Adds it to the HashTable Answers.
   
*/


import java.util.*;
import java.lang.Math;

class ComplexNumbers{

   final static Scanner SystemScanner = new Scanner(System.in);
   static HashMap<String, String> Answers = new HashMap<String, String>();

   static void Addition(double a1, double a2, double b1, double b2){
      //z1 + z2=(a1+a2) +  i*(b1+b2)
      
      double Left = (a1 + a2);
      double Right = (b1 + b2);
      
      Answers.put("Addition", String.format("%s + i*%s", Left, Right));
   }
   
   static void Subtraction(double a1, double a2, double b1, double b2){
      //z1 - z2=(a1-a2) +  i*(b1-b2)
      
      double Left = (a1 - a2);
      double Right = (b1 - b2);
      
      Answers.put("Subtraction", String.format("%s + i*%s", Left, Right));
   }

   static void Multiplication(double a1, double a2, double b1, double b2){
      //z1*z2 = (a1*a2 – b1*b2) + i*(a1*b2 + b1*a2)
      
      double Left = (a1 * a2 - b1 * b2);
      double Right = (a1 * b2 + b1 * a2);
      
      Answers.put("Multiplication", String.format("%s + i*%s", Left, Right));
   }

   static void Division(double a1, double a2, double b1, double b2){
      //z1/z2 = (a1*a2 +b1*b2)/(a2^2 + b2^2) + i*(b1*a2 – a1*b2)/(a2^2 + b2^2) 
      
      double Left = (a1 * a2 + b1 * b2) / (Math.pow(a2, 2) + Math.pow(b2, 2));
      double Right = (b1 * a2 - a1 * b2) / (Math.pow(a2, 2) + Math.pow(b2, 2));
      
      Answers.put("Division", String.format("%s + i*%s", Left, Right));
   }


   public static void main(String[] args){
   
      System.out.println("Please enter 4 numbers seperated by , for example: 1,2,3,4.");
      
      String Numbers = SystemScanner.nextLine();
      String[] NumberList = Numbers.split(",");
      
      double a1 = Integer.valueOf(NumberList[0]); // No built in unpack method in java.
      double a2 = Integer.valueOf(NumberList[1]);
      double b1 = Integer.valueOf(NumberList[2]);
      double b2 = Integer.valueOf(NumberList[3]);
      
      Division(a1, a2, b1, b2);
      Multiplication(a1, a2, b1, b2);
      Subtraction(a1, a2, b1, b2);
      Addition(a1, a2, b1, b2);
      
      System.out.println(String.format("The Answer given: a1 = %s, a2 = %s, b1 = %s, b2 = %s is as follows: ", a1, a2, b1, b2));
      
      Answers.forEach((Key, Value) -> {
         
         String StringKey = (String)Key; // convert from object to string to prevent errors.
         String StringValue = (String)Value;

         System.out.println(String.format("%s = %s", StringKey, StringValue));
         
      });
   }
}