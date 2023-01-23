import java.util.*;






public class Module_7{
   
   final static Scanner MyScanner = new Scanner(System.in);
   
   public static void DisplayMessage(String MessageToDisplay) { // utility method to display
      System.out.println(MessageToDisplay);
   }
   
   private static int PromptForNumber(){
      System.out.println("Please enter the number which we will solve for." );
      return MyScanner.nextInt();
   }
   
   private static int Factorial(){
      
      int Answer = 1;
      
      for(int i = PromptForNumber(); i > 0; i--){
         Answer *= i;
      }
      
      return Answer;
   }
   
   public static int Sum(){
   
      int Answer = 1;
      
      for(int i = PromptForNumber(); i > 0; i--){
         Answer += i;
      }
      
      return Answer;

      
   }
   
   public static void main(String[] args){
      
      DisplayMessage("Please enter one of the following options: factorial, sum or break to end the program!");
      String UserChoice = MyScanner.nextLine(); // We get the next line which the user enters here...
      int Answer = 0; // Lets init a variable for the return value from user choice.
      
      switch(UserChoice){
      
         case "factorial":
             Answer = Factorial();
             DisplayMessage(String.format("The answer to your problem is: %s", Answer));
             break;
         case "sum":
             Answer = Sum();
             DisplayMessage(String.format("The answer to your problem is: %s", Answer));
             break;
         case "break":
            break;
         default:
            DisplayMessage("Invalid input! Please try again!");
            main(args);
         
      
      }
   }
   
   
}