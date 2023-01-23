/* 
Sam 1/29/22 2 PM CST


Solves problem 4 Module 3.

*/

import java.util.*;
import java.lang.*;

class Builder{
   
   private StringBuilder NewString;
   private Scanner SystemScanner = new Scanner(System.in);
   
   private String PromptInput(String Prompt){
      System.out.println(String.format("Please type: %s on your keyboard.", Prompt));
      return SystemScanner.nextLine();
   }
   
    private void AppendString(){
      this.NewString.append(" %s, I love it!");
   }
   
   public Builder(){
      this.NewString = new StringBuilder(PromptInput("Java is fun!"));
      AppendString();
   }
   
   @Override
   public String toString(){
      return String.format(this.NewString.toString(), PromptInput("Yes")) + " with a capacity of: " + this.NewString.capacity();
   }
}


class Start{

   public static void main(String[] args){
      Builder NewBuilder = new Builder();
      System.out.println(NewBuilder);
   }

}
