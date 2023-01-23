/*
Sam 2/6/22 12:26 am CST

I did this at 12 am in the morning because the steroid shot that the doc gave me finally decided to kick in. 
Would have been nice if it worked during the day and not while I was trying to sleep. Guess thats what I get for being sick, smh...

Problem 1 Module 4

Sports statistics:            
 
I was playing around with custom packages. I managed to figure out how they work finally.
*/

import java.util.*;
import Problem_1.*;



class Main{

   public static void main(String[] args){
   
      Football NewFootball = new Football("Auburn Football");
      Football NewFootball_1 = new Football("Alabama Football");

      for(int i = 1; i < 200; i++){
         NewFootball_1.AddScore(i, i * 2, NewFootball.Team);
         NewFootball.AddScore(i * 2, i, NewFootball_1.Team);
      }

      System.out.println(NewFootball_1);
            
   }

}