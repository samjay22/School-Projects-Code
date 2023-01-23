/*
Sam 1/16/22 9:46 CST

Solves the vending machine problem.

Methods:

   HashMap GetProducts() # Returns the products as a HashMap.
   HashMap GetCoinNames() # Reuturns the coin names.
   
   boolean AllowedAmount() # Checks if the user entered a valid amount found in ALLOWEDCURRENCY.
   
   double GetMoney() # Allows for user to input the money amount they wish to use in the current session.
   
   void DisplayValidAmounts() # Prompts the user to enter one of the following amounts from the list found in ALLOWEDCURRENCY.
   void DisplayProductOptions() # Prompts the user to select a product from the list found in the HashMap ProductList.
   void ReturnChange() # Calculates the change the user recieves after purchasing or stopping session.
   void PromptPurchase() # Prompts the user with the list of items they can purchase from the ProductList HashMap.
   
*/

import java.util.*;
import java.lang.Math;

class VendingMachine{

   final static double ALLOWEDCURRENCY[] = {0.01, 0.05, 0.10, 0.25, 1.00, 5.00}; // our allowed currency.
   final static Scanner SCANNEROBJECT = new Scanner(System.in);
   
   static ArrayList<String> AttemptedPurchases = new ArrayList<String>(); // keep track of attempted purchases.
   
   static HashMap ProductList = GetProducts();
   static HashMap CoinNames = GetCoinNames();
   
   static double MoneyToSpend = 0;
   
   static boolean CanPurchaseItem = true;
   
   static HashMap GetCoinNames(){ // gets coin names.
      HashMap<Double, String> CoinNames = new HashMap<Double, String>(5); // init Map
      
      CoinNames.put(0.25, "Quarter");
      CoinNames.put(0.1, "Dime");
      CoinNames.put(0.05, "Nickle");
      CoinNames.put(0.01, "Penny");
      
      return CoinNames;
   }
   
   static HashMap GetProducts(){ // gets products
   
      HashMap<String, Double> Products = new HashMap<String, Double>(5); // init Map
      
      Products.put("1 Coke",  1.25);
      Products.put("2 Candy Bar",  0.75);
      Products.put("3 Gum",  0.25);
      Products.put("4 Chips",  2.25);
      Products.put("5 Coffee",  3.00);
      
      return Products;
   }
   
   
   
   static boolean AllowedAmount(double Amount){
      for(double i : ALLOWEDCURRENCY){
         if(i == Amount){
            return true;
         }
      }
      return false;
   }
   
   static void DisplayValidAmounts(){
      for(double i : ALLOWEDCURRENCY){
         System.out.println(i);
      }
   }
  
   static void DisplayProductOptions(){      
      ProductList.forEach((Key, Value) ->{
         if(!AttemptedPurchases.contains(Key)){
            System.out.println(String.format("%s Costs: $%s", Key, Value));
         }
      });
      
   }
   
   static double GetMoney(){
      
      double CurrencyAmount = 0; // Cant pass by pointer like in C++ ;(
      double EnteredAmount = 1.0;
      
      while(EnteredAmount != 0){
      
         System.out.println("Please Enter Amount from the list given: ");
         EnteredAmount = SCANNEROBJECT.nextDouble(); // We get input here.
         
         if(AllowedAmount(EnteredAmount)){
            CurrencyAmount += EnteredAmount;
         }
         else if(EnteredAmount == 0){
            break;
         }
         else{
            DisplayValidAmounts();
         }
      }
      return Math.round(CurrencyAmount * 100.0) / 100.0; // prevent an impossible number.
   }
   
   static void ReturnChange(){
   
      HashMap<Double, Integer> Change = new HashMap<Double, Integer>();
      int ConvertedChange = (int)(MoneyToSpend * 100);
      
      Change.put(0.25, 0);
      Change.put(0.10, 0);
      Change.put(0.05, 0);
      Change.put(0.01, 0);
      
     while(ConvertedChange - 25 >= 0){
         ConvertedChange -= 25;
         Change.put(0.25, Change.get(0.25) + 1);
      }       
      
      while(ConvertedChange - 10 >= 0){
         ConvertedChange -= 10;
         Change.put(0.10, Change.get(0.10) + 1);
      } 
      
      while(ConvertedChange - 5 >= 0){
         ConvertedChange -= 5;
         Change.put(0.05, Change.get(0.05) + 1);
      } 
      
      while(ConvertedChange - 1 >= 0){
         ConvertedChange -= 1;
         Change.put(0.01, Change.get(0.01) + 1);
      } 
      
      System.out.println(String.format("Change Due: %s", MoneyToSpend));
      System.out.println(String.format("Here are your coins: "));
      
      Change.forEach((Key,Value) -> {
         
         
         double KeyValue = (double)Key;
         
         String CoinName = (String)CoinNames.get(KeyValue);
         
         System.out.println(String.format("%s : %s", CoinName, Value));
         
      });
          
   }
   
   static void PromptPurchase(){
      
      while(AttemptedPurchases.size() != 5 && CanPurchaseItem){
      
         int Selected = SCANNEROBJECT.nextInt();   
         
         if(Selected == 0){
            ReturnChange();
            break;
         }
         
         for ( Object Key : ProductList.keySet() ) {
         
            String ConvertedKey = (String)Key;
            double ConvertedValue = (double)ProductList.get(ConvertedKey);
            String SelectedString = Integer.toString(Selected);
            
            if(ConvertedKey.contains(SelectedString) && ConvertedValue <= MoneyToSpend){
               MoneyToSpend -= ConvertedValue;
               ReturnChange();
               return;
            }
            else if(ConvertedKey.contains(SelectedString) && ConvertedValue > MoneyToSpend && MoneyToSpend != 0){
               System.out.println("Not enough funds; please try again!");
               AttemptedPurchases.add(ConvertedKey);
               DisplayProductOptions();
            }
            else if(MoneyToSpend <= 0){
                System.out.println("Cant SPend $0");
                CanPurchaseItem = false;
                return;
            }  

         }
                
      }
      
   }
   
   public static void main(String[] args){

       DisplayValidAmounts(); // we display the valid amounts.
       MoneyToSpend = GetMoney(); // get the money that the user is entering.
       System.out.println(String.format("You have %s to spend, please choose from the following options: ", MoneyToSpend));
       DisplayProductOptions();
       PromptPurchase();
      
   }
}