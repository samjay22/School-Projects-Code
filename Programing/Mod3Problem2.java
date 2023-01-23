/* 
Sam 1/29/22 2 PM CST


Solves problem 2 Module 3.

*/

import java.util.*;
import My_Package.*;

class Cycle{

   private int Weight;
   private int Wheels;
   
   
   public Cycle(int Weight, int Wheels){
      this.Wheels = Wheels;
      this.Weight = Weight;
   }
   
   @Override
   public String toString(){
      return String.format(" Weight: %s \n Wheels: %s ", this.Weight, this.Wheels);
   }

}

class Test{
   
   public static void main(String[] args){
      Cycle NewCycle = new Cycle(500, 4);
      System.out.println(NewCycle);
   }
   
}